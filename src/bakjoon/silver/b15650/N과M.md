https://www.acmicpc.net/problem/15650

### 문제 풀이 날짜
2025-10-13

### 문제 분석 요약
- 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열을 출력하는 문제

### 제약조건
- 고른 수열은 오름차순이어야 한다.
- 자연수 N과 M은 (1 ≤ M ≤ N ≤ 8)
- 중복되는 수열을 여러 번 출력하면 안 된다.
### 알고리즘 설계

#### 변수
-  입력받는 자연수 N, M
-  `int[] selected` : 현재까지 선택한 숫자들을 저장할 배열 (크기 M)
- `int depth`: 현재까지 선택한 숫자의 개수
- `int start` 다음에 선택할 수 있는 시작 숫자
#### 입력
- 자연수 N, M을 입력받는다

#### 연산
- 백트래킹 함수를 호출한다
- 백트래킹 함수
    1. 종료조건 : depth가 M과 같으면 selected 배열을 출력하고 return
    2. 탐색과정 : start 부터 N까지 반복하면서
        - 현재숫자 i를 selected[depth]에 저장
        - 백트래킹 함수를 재귀호출(depth + 1, start를 i + 1로 전달)
        - 재귀가 끝나면 다음 숫자로 이동
    3. start값을 i + 1로 전달
#### 출력
- M개를 모두 선택했을 때 수열을 한 줄에 출력

### 시간 복잡도
- O(C(N, M) × M)
    - N개 중에서 중복없이 M개를 순서대로 고르는 조합의 개수

### 코드
```java  
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] selected;  // 현재까지 선택한 숫자들을 저장
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        selected = new int[M];
        
        backtrack(0, 1);  // 0개 선택, 1부터 시작
        System.out.print(sb);
    }
    
    // depth: 현재까지 선택한 개수
    // start: 다음에 선택할 수 있는 시작 숫자
    static void backtrack(int depth, int start) {
        // M개를 모두 선택했으면 출력
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        // start부터 N까지 숫자를 하나씩 선택
        for (int i = start; i <= N; i++) {
            selected[depth] = i;           // i를 선택
            backtrack(depth + 1, i + 1);   // 다음 숫자 선택 (i+1부터 가능)
            
        }
    }
}
```


### 알게된점
- 처음에 반복문으로 풀려고 했었는데 반복문으로는 모든 가능한 경우를 만들 수 없다
- 백트래킹으로 풀어야 가장 효과적으로 풀 수 있다는 것을 알게되었다 