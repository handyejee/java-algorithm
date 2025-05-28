package bakjoon.bronze.b1864;

import java.io.*;

public class B1864 {

  public static void main(String[] args) throws IOException {

//    1. 문어 숫자를 입력 받는다
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      //    - 공백 기준(readLine) 으로 문자열을 입력을 받는다
      String octopusString = br.readLine();
      //    - while문으로 반복해 `#` 이 있으면 반복문을 종료한다
      if (octopusString.equals("#")) break;

      int result = 0;
      int length = octopusString.length();

//    2.  문자열의 원소 위치에 따라서 문자에 대응하는 숫자 x 8진법 자리수를 계산해준다
      for (int i = 0; i < length; i++) {
        char c = octopusString.charAt(i);

        int changeNum = 0;
        switch (c) {
          case '-':
            changeNum = 0;
            break;
          case '\\':
            changeNum = 1;
            break;
          case '(':
            changeNum = 2;
            break;
          case '@':
            changeNum = 3;
            break;
          case '?':
            changeNum = 4;
            break;
          case '>':
            changeNum = 5;
            break;
          case '&':
            changeNum = 6;
            break;
          case '%':
            changeNum = 7;
            break;
          case '/':
            changeNum = -1;
            break;
        }
//        - 자리수 계산하는 법: `문자열길이 - 1 - 현재인덱스`
        int value = length - 1 - i;
        result += (int) (changeNum * Math.pow(8, value)); // 자리수를 8 제곱으로 더해준다
      }
      //    3. 계산한 숫자를 출력해준다
      System.out.println(result);
    }
  }
}
