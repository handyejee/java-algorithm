https://www.acmicpc.net/problem/9417

### 문제 풀이 날짜
2025-09-11

### 문제 분석 요약
- 정수 M개가 주어졌을 때, 모든 두 수의 쌍 중에서 가장 큰 최대공약수 찾는 프로그램

제약조건
- 모든 수는 -231보다 크거나 같고, 231 -1보다 작거나 같다.
### 알고리즘 설계

#### 입력
- 테스트케이스 개수 N을 입력받는다
- 정수 M(N개에 해당하는 숫자 모음)을 입력받는다
  - 리스트에 한줄에 있는 숫자들을 입력 받는다
    - 갯수가 정해지지 않았기 때문에 리스트 사용

#### 연산
- 입력받은 숫자들을 최대공약수 구하는 유클리드 호제법을 사용해서 구해준다
  - 리스트의 각 숫자들을 순회하면서 최대공약수를 구한다
  - 구한 수중 최대공약수의 최대 값을 구한다(Math.max)
### 시간 복잡도
- O(N × M²)
- 3중반복문이지만 N개의 테스트 케이스에 대해서만 이중반복이 이루어지고 있다. M^2
- 연산횟수는 최악의 경우에 100 * 100^2 = 100만번 
### 코드
```java  
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 테스트케이스 수

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int tc = 0; tc < N; tc++) {
            numbers.clear();
            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) { // 한줄에 여러개의 숫자를 넣기 위해 hasMoreTokens 사용
                numbers.add(Integer.parseInt(st.nextToken()));
            }

            // 연산
            int max = 0;
            for (int i = 0; i < numbers.size(); i++) {
                for (int j = i + 1; j < numbers.size(); j++) {
                    int num = gcd(numbers.get(i), numbers.get(j));
                    max = Math.max(num, max);
                }
            }
            // 출력
            bw.write(max + "\n");
        }
        // 출력
        bw.flush();
        bw.close();
        br.close();
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int remainder = a % b;

            a = b;
            b = remainder;
        }
        return a;
    }
}
```
![b9417](b9417.png)

### 느낀점 or 기억할 정보
- 이차원 리스트를 사용해야 된다고 생각했는데 한줄에 여러개의 숫자를 여러 줄로 입력받을 때 hasMoreTokens() 메서드를 사용하면서 한줄씩 출력해주는 방법이 더 효과적이라는 것을 알게되었다