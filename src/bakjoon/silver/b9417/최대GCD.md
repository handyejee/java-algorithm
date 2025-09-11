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
- 정수 M을 입력받는다

#### 연산
- 리스트에 한줄에 있는 숫자들을 입력 받는다
- 입력받은 숫자들을 최대공약수 구하는 유클리드 호제법을 사용해서 구해준다
### 시간 복잡도
- O(N)
### 코드
```java  
import java.io.*;  
import java.util.*;  
  
public class B9417 {  
    public static void main(String[] args) throws IOException {  
        // 입력  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
  
        int N = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N ; i++) {
	        st = new StringTokenizer(bf.readLine()); 
			while (st.hasMoreTokens()) {    
			list.add(Integer.parseInt(st.nextToken())); }
        }  
        // 연산
        int max = 0;
        for (int j = 0; j < list.size(); j++) {
	        for (int k = j + 1; k < list.size(); k++) {
		        int num = gcd(list.get(j), list.get(k));
		        max = Math.max(num, max);
	        }
        }
        bw.write(max + "\n");
        list.clear();
    }  
  
    public static int gcd(int a, int b) { // 최대공약수  
		if (b == 0) { 
			return a; 
			} 
			return gcd(b, a % b); 
		}
	}  
  
}
```

### 느낀점 or 기억할 정보
- 이차원 리스트를 사용해야 된다고 생각했는데 한줄에 여러개의 숫자를 여러 줄로 입력받을 때 hasMoreTokens() 메서드를 사용하면서 한줄씩 출력해주는 방법이 더 효과적이라는 것을 알게되었다