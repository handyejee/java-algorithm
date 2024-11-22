package math;

// 프로그래머스 12947 하샤드 수
public class P12947 {

  public boolean solution(int x) {

    String num = String.valueOf(x); // 문자열 변환
    int total = 0;

    for (int i = 0; i < num.length(); i++) {
      total += num.charAt(i) - '0'; // 다시 숫자로 변환
    }

    return x % total == 0; // 나눠지는지 확인
  }
}
