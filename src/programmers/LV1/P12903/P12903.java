package programmers.LV1.P12903;

public class P12903 {
  public String solution(String s) {
    int length = s.length();

    if(length % 2 == 0) {
      return s.substring(length / 2 - 1, length / 2 + 1);
    } else { // 홀수
      return s.substring(length / 2, length / 2 + 1);
    }
  }
}