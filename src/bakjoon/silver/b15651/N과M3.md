https://www.acmicpc.net/problem/15651

### 문제 풀이 날짜 
2025-11-28

### 문제 분석 요약
-  1부터 N까지의 자연수 중에서 M개를 고른 수열 생성
- 같은 수를 여러 번 사용 가능 (중복 허용)

### 문제의 핵심
- 중복조합 문제: 같은 수를 여러 번 선택할 수 있으며, 순서는 고려하지 않음
### 제약조건
- 1 ≤ M ≤ N ≤ 7
### 알고리즘 설계

#### 입력
- `N`: 1부터 N까지의 자연수
- `M`: 선택할 수의 개수
#### 연산
- 백트래킹(DFS) 사용
    - 현재 위치(start)부터 N까지 탐색
    - 현재 수를 선택하고 다음 깊이로 이동
#### 출력
- 조건을 만족하는 모든 수열을 사전순으로 출력
### 시간 복잡도
- O(N^M)
    - 각 위치에서 최대 N개의 선택지
    - M개의 깊이
### 코드
```java  
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] sequence;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        sequence = new int[M];
        
        backtrack(0, 1);
        
        System.out.print(sb);
    }
    
    // depth: 현재 선택한 수의 개수
    // start: 탐색 시작 위치 (비내림차순 보장)
    static void backtrack(int depth, int start) {
        // M개를 모두 선택한 경우
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(sequence[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        // start부터 N까지 탐색 (중복 허용 + 비내림차순)
        for (int i = start; i <= N; i++) {
            sequence[depth] = i;
            // 다음 탐색도 i부터 시작 (같은 수 재사용 가능)
            backtrack(depth + 1, i);
        }
    }
}
```

### 알게된점
- 