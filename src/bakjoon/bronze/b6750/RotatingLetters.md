https://www.acmicpc.net/problem/6750

### 풀이 날짜
2025-09-29

### 문제 분석 요약
- 간판을 만드는 문제
- 180도 회전했을때도 모양이 변하지 않는 글자를 사용 (I, O, S, H, Z, X, N)
- 입력받은 단어가 간판에 사용될 수 있는지 YES, NO로 판별하는 프로그램

### 제약조건
- 대문자로만 이루어진 한개 단어
- 단어 최대 길이 30글자
- 최소 1글자 이상
### 알고리즘 설계

#### 변수
- 입력받은 문자열을 저장한 word
- 유효한 문자를 저장한 문자열 validLetters
#### 입력
- 단어 문자를 입력받는다

#### 연산
- character 로 변환해서 순회한다
    - 허용되지 않는 문자라면 NO를 출력
        - validLetters의 index값이 word에 있는 문자가 아닌지 확인
        - `validLetters.indexOf(c) == -1` 로 표현 가능
    - 반환한다
- 그 외에 경우에는 YES를 출력

### 시간 복잡도
- O(N)
    -  단어의 크기만큼 순회하면서 확인한다
### 코드
```java  
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        String valid = "IOSHZXN";
        
        for (char c : word.toCharArray()) {
            if (valid.indexOf(c) == -1) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
```
![b6750](./b6750.png)

### 느낀점 or 기억할 정보
- 문자열 문제를 만날때마다 어떤 자료형으로 변환을 해야될지 고민이 많이 된다
- 이 문제에서는 처음에는 입력받는 문자열과 지정된 단어 모두 String으로 담은다음 반복문에서 char로 순회하는 방식으로 사용했는데, 이 방법이 처음부터 고민을 줄일 수 있는 방법인것 같다. 
