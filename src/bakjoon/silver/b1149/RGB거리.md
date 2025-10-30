https://www.acmicpc.net/problem/1149

### 문제 풀이 날짜
2025-10-30

### 문제 분석 요약
- RGB거리에 집이 N개 있다
- 집을 빨강, 초록, 파랑 중 하나로 칠할때 최소의 비용으로 칠할 수 있는 최솟값을 구하는 문제
    - 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
    - N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
    - i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.

26 40 83 빨강 초록 파랑
49 60 57 파랑
13 89 99 빨강
26 + 57 + 13 = 96

### 제약조건
- 집의 수 N(2 ≤ N ≤ 1,000)
- 집을 칠하는 비용은 1,000보다 작거나 같은 자연수
### 알고리즘 설계

문제의 핵심
- DP를 사용하여 각 집까지의 최소 비용을 계산
- 인접한 집은 다른 색으로 칠해야 하므로, 이전 집의 색을 고려하여 현재 집의 최소 비용 결정

#### 변수
- `int N`: 집의 개수
- `int[][] cost`: 각 집을 RGB로 칠하는 비용 (cost[i][0]=빨강, cost[i][1]=초록, cost[i][2]=파랑)
- `int[][] dp`: dp[i][j] = i번째 집을 j색으로 칠했을 때의 최소 누적 비용
#### 입력
- 첫째줄 집의 수 N
- 다음 N개 줄: 각 집을 빨강, 초록, 파랑으로 칠하는 비용
#### 연산
1. 초기화 단계
- 첫 번째 집(0번 집)은 이전 집이 없으므로, 각 색의 비용을 그대로 dp 테이블에 저장합니다.
- 빨강으로 칠하는 최소 비용 = cost[0][0]
- 초록으로 칠하는 최소 비용 = cost[0][1]
- 파랑으로 칠하는 최소 비용 = cost[0][2]

2. 점화식 계산 (i번째 집, i >= 1)
- i번째 집을 특정 색으로 칠할 때, 이전 집(i-1번)은 다른 색이어야 합니다.
- 따라서 이전 집의 두 가지 다른 색 중 최소 비용을 선택하고, 현재 집의 비용을 더합니다.
- i번째 집을 빨강으로 칠하는 경우:
    - 이전 집은 초록 또는 파랑이어야 함
    - dp[i][0] = cost[i][0] + min(dp[i-1][1], dp[i-1][2])
- i번째 집을 초록으로 칠하는 경우:
    - 이전 집은 빨강 또는 파랑이어야 함
    - dp[i][1] = cost[i][1] + min(dp[i-1][0], dp[i-1][2])
- i번째 집을 파랑으로 칠하는 경우:
    - 이전 집은 빨강 또는 초록이어야 함
    - dp[i][2] = cost[i][2] + min(dp[i-1][0], dp[i-1][1])

3. 최종 답 계산
- 마지막 집(N-1번)을 세 가지 색 중 하나로 칠했을 때의 최소 비용을 비교합니다.
- 답 = min(dp[N-1][0], dp[N-1][1], dp[N-1][2])
#### 출력
- 모든 집을 칠하는 비용의 최솟값
### 시간 복잡도
- O(N)
- N개의 집을 순회하며 각 집마다 상수 시간(3가지 색 비교) 연산 수행
- 전체 시간 복잡도: O(3N) = O(N)
### 코드
```java  
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken()); // 빨강
            cost[i][1] = Integer.parseInt(st.nextToken()); // 초록
            cost[i][2] = Integer.parseInt(st.nextToken()); // 파랑
        }
        
        // DP 테이블 생성
        int[][] dp = new int[N][3];
        
        // 초기값: 첫 번째 집
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];
        
        // DP 계산
        for (int i = 1; i < N; i++) {
            // i번째 집을 빨강으로 칠하는 경우: 이전 집은 초록 또는 파랑
            dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            
            // i번째 집을 초록으로 칠하는 경우: 이전 집은 빨강 또는 파랑
            dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            
            // i번째 집을 파랑으로 칠하는 경우: 이전 집은 빨강 또는 초록
            dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        
        // 출력: 마지막 집의 세 가지 색 중 최솟값
        int answer = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));
        System.out.println(answer);
    }
}
```

동작 과정 (예제 1)
```
입력:
3
26 40 83
49 60 57
13 89 99

DP 과정:
dp[0] = [26, 40, 83]

dp[1][0] = 49 + min(40, 83) = 89
dp[1][1] = 60 + min(26, 83) = 86
dp[1][2] = 57 + min(26, 40) = 83

dp[2][0] = 13 + min(86, 83) = 96
dp[2][1] = 89 + min(89, 83) = 172
dp[2][2] = 99 + min(89, 86) = 185

답: min(96, 172, 185) = 96
```

### 알게된점
