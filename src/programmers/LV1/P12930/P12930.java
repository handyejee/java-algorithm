package programmers.LV1.P12930;

public class P12930 {
  public String solution(String s) {
    String answer = "";
    String[] words = s.split(" ", -1); // 공백기준으로 나눔

    for (int i = 0; i < words.length; i++) { // char 로 변경
      char[] charArr = words[i].toCharArray();

      for (int j = 0; j < charArr.length; j++) {
        if (j % 2 == 0) { // 대소문자 변경
          charArr[j] = Character.toUpperCase(charArr[j]);
        } else {
          charArr[j] = Character.toLowerCase(charArr[j]);
        }
      }

      answer += new String(charArr); // char -> String
      if (i < words.length - 1) {
        answer += " ";
      }
    }
    return answer;
  }
}
