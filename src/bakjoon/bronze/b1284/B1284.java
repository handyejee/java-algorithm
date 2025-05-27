package bakjoon.bronze.b1284;

import java.io.*;

public class B1284 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true){
      // 집 번호 입력받기
      String houseNum = br.readLine();
      if (houseNum.equals("0")) break;

      // 숫자 양쪽 너비
      int width = 2;

      for (int i = 0; i < houseNum.length(); i++) {
        char digit = houseNum.charAt(i);

        if (digit == '1'){
          width += 2;
        } else if (digit == '0') {
          width += 4;
        } else {
          width +=3;
        }

        if (i < houseNum.length() -1) {
          width += 1;
        }
      }
      System.out.println(width);
    }
  }
}
