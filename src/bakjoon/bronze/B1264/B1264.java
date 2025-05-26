package bakjoon.bronze.B1264;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1264 {

  public static void main(String[] args) throws IOException {
    char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      String sentence = br.readLine(); // 공백 기준으로 문장 입력받기
      if(sentence.equals("#")) break; // while문 탈출조건

      int count = 0; // 모음 개수 세어줄 변수
      for (char c : sentence.toCharArray()) { // 문장내부를 반복
        for (char vowel : vowels) { // 해당 글자가 모음
          if (c == vowel) {
            count++;
            break; // 다음글자 탐색을 위한 break
          }
        }
      }
      System.out.println(count); // 모음 개수 출력
    }
  }
}
