package bakjoon.bronze.b2566;

import java.io.*;
import java.util.StringTokenizer;

public class B2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 9x9 배열 선언
        int[][] array = new int[9][9];

        // 2차원배열에 입력하기
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 한줄씩 읽어오기
            for (int j = 0; j < 9; j++) {
               array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxNum = array[0][0];
        int maxRow = 0;
        int maxCol = 0;

        // 최대값과 위치 찾기
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (array[i][j] > maxNum) {
                    maxNum = array[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        System.out.println(maxNum);
        System.out.println(maxCol + 1 + " " + maxRow);
    }
}
