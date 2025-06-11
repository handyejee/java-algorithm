https://www.acmicpc.net/problem/14453

### 풀이 날짜
2025-06-11

### 문제 분석 요약
- Hoof beats scissors (since a hoof can smash a pair of scissors), scissors beats paper (since scissors can cut paper), and paper beats hoof (since the hoof can get a papercut).
    - hoof > scissors
    - scissors > paper
    - papaer > hoof
- N games of "Hoof, Paper, Scissors" (1 ≤ N ≤ 100,000)
- she is only willing to switch gestures at most once over the entire set of games
    - she might play "hoof" for the first x games, then switch to "paper" for the remaining N−x games
- determine the maximum number of games that Bessie can win

- 가위바위보 게임을 FJ와 Bessie가 하는데 Bessie가 이길 수 있는 최대 게임 개수를 구하는 문제
- N번 게임을 진행하고 N의 크기는 (1 ≤ N ≤ 100,000)
- N을 입력받고 N만큼 P, H, S 를 입력받는다
- Bessie는 전체 N번의 게임 중 한번만 동작을 바꿀 수 있다

### 알고리즘 설계
#### 필요한 값
- 정수 N
- 누적합 결과를 담을 이차원배열 prefix
- 반환할 결과값 변수 maxWins
#### 풀이순서
1. 총 게임 횟수 N을 입력받는다
2. 입력받으면서 동시에 누적합 계산
3. 누적합을 이용해 모든 전략의 승리 횟수 계산
4. 최대값 반환

### 시간 복잡도
- O(N): 한 번의 순회로 모든 부분합 확인
- 최대 연산 횟수
    - 9N = 9 × 100,000 = 900,000

이 문제를 이중반복문으로 풀게 되면 100,000 x 100,000 최대 100억 번 연산이 필요하는데 제한시간 2초에는 초과가 된다. 그래서 누적합 개념을 사용해서 중복이 되는 연산을 줄여서 시간 복잡도를 줄여야 한다.
![b24453_1](b24453_1.png)

중복이 되는 연산은 Bessie가 1회만 행동을 변경할 수 있기 때문에 같은 연산이 발생하게 된다. 이 부분이 처음에 이해가 잘 안갔는데 H, S, P에 대해서 결과가 정해져 있기 때문에 모든 경우에 대해서 연산을 배열에 해두고 실제 값이 들어오는 경우에 바로 계산해서 값을 구할 수 있도록 한다고 이해했다.

누적합의 개념이 여기서 사용이 된다. 이 문제에서는 누적합을 사용하기 위해서 이중 반복문을 사용했다. H, S, P 3가지의 행동이 정해져 있기 때문에 `[3][N + 1]` 의 형태로 H, S, P로 이겼을때의 합이 배열에 저장된다.
### 코드
```java
import java.io.*; 

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // P=0, H=1, S=2로 매핑
        int[][] prefix = new int[3][N + 1];
        
        for (int i = 1; i <= N; i++) {
            char input = br.readLine().charAt(0);
            
            // 이전 값 복사
            for (int j = 0; j < 3; j++) {
                prefix[j][i] = prefix[j][i-1];
            }
            
            // 현재 입력에 따라 증가
            if (input == 'P') prefix[0][i]++;      // 베시가 S로 이김
            else if (input == 'H') prefix[1][i]++; // 베시가 P로 이김  
            else if (input == 'S') prefix[2][i]++; // 베시가 H로 이김
        }
        
        int maxWins = 0;
        
        // 모든 (첫번째 제스처, 두번째 제스처) 조합
        for (int first = 0; first < 3; first++) {
            for (int second = 0; second < 3; second++) {
                // 모든 분할점에서 시도
                for (int split = 0; split <= N; split++) {
                    int frontWins = prefix[first][split];
                    int backWins = prefix[second][N] - prefix[second][split];
                    maxWins = Math.max(maxWins, frontWins + backWins);
                }
            }
        }
        
        System.out.println(maxWins);
    }
}
```
![b24453_2](b24453_2.png)

### 느낀점 or 기억할 정보
- 부루트포스 방법만 생각이 나는데 개념을 어떻게 활용할지 더 고민이 필요하다