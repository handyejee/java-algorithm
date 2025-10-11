package bakjoon.silver.b2563;

import java.util.*;
import java.io.*;

public class B2563 {
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[][] paper = new boolean [100][100];
        int n = Integer.parseInt(br.readLine()); // 색종이 수

        for (int i = 0; i < n; i++) { // 색종이 위치
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 연산
            // 색종이 별 영역 표시
            for (int row = 0; row < x + 10 ; row++) {
                for (int col = 0; col < y + 10; col++) {
                    paper[row][col] = true;
                }
            }
        }

        // 검은 영역 계산
        int area = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (paper[i][j]) area++;
            }
        }

        // 출력
        System.out.println(area);
    }
}
