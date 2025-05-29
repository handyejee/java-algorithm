package bakjoon.bronze.b2037;

import java.io.*;
import java.util.StringTokenizer;

public class b2037 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int p = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());

    String message = br.readLine();

    // 각 문자가 몇번 키인지, 몇 번 눌러야 하는지 저장하는 로직
    int[] keyNum = new int[27];
    int[] pressCount = new int[27];

    // 2번 키: ABC
    keyNum[0] = 2; pressCount[0] = 1;  // A
    keyNum[1] = 2; pressCount[1] = 2;  // B
    keyNum[2] = 2; pressCount[2] = 3;  // C

    // 3번 키: DEF
    keyNum[3] = 3; pressCount[3] = 1;  // D
    keyNum[4] = 3; pressCount[4] = 2;  // E
    keyNum[5] = 3; pressCount[5] = 3;  // F

    // 4번 키: GHI
    keyNum[6] = 4; pressCount[6] = 1;  // G
    keyNum[7] = 4; pressCount[7] = 2;  // H
    keyNum[8] = 4; pressCount[8] = 3;  // I

    // 5번 키: JKL
    keyNum[9] = 5;  pressCount[9] = 1;   // J
    keyNum[10] = 5; pressCount[10] = 2;  // K
    keyNum[11] = 5; pressCount[11] = 3;  // L

    // 6번 키: MNO
    keyNum[12] = 6; pressCount[12] = 1;  // M
    keyNum[13] = 6; pressCount[13] = 2;  // N
    keyNum[14] = 6; pressCount[14] = 3;  // O

    // 7번 키: PQRS
    keyNum[15] = 7; pressCount[15] = 1;  // P
    keyNum[16] = 7; pressCount[16] = 2;  // Q
    keyNum[17] = 7; pressCount[17] = 3;  // R
    keyNum[18] = 7; pressCount[18] = 4;  // S

    // 8번 키: TUV
    keyNum[19] = 8; pressCount[19] = 1;  // T
    keyNum[20] = 8; pressCount[20] = 2;  // U
    keyNum[21] = 8; pressCount[21] = 3;  // V

    // 9번 키: WXYZ
    keyNum[22] = 9; pressCount[22] = 1;  // W
    keyNum[23] = 9; pressCount[23] = 2;  // X
    keyNum[24] = 9; pressCount[24] = 3;  // Y
    keyNum[25] = 9; pressCount[25] = 4;  // Z

    // 1번 키: 공백
    keyNum[26] = 1; pressCount[26] = 1;

    int totalTime = 0;
    int prevKey = -1;  // 이전에 사용한 키 번호

    for (int i = 0; i < message.length(); i++) {
      char c = message.charAt(i);

      // 현재 문자 인덱스 구하기
      int index = (c == ' ') ? 26 : c - 'A';

      // 현재 문자의 키 번호와 누르는 횟수
      int currentKey = keyNum[index];
      int press = pressCount[index];

      // 이전키번호와 현재키번호가 같으면 대기시간 추가
      if (prevKey == currentKey && c != ' ') {
        totalTime += w;
      }

      // 버튼 누르는 시간 추가
      totalTime += p * press;

      // 현재 키를 이전 키로 저장
      prevKey = currentKey;
    }
    System.out.println(totalTime);
  }
}
