package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1890 {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(br.readLine()); // 게임판의 사이즈
      int[][] gameArr = new int[N][N]; // 게임판 배열 선언
      long[][] dp = new long[N][N]; // dp 배열 선언 : 가능한 경로가 int 범위를 넘어설수 있어 long으로 선언
      dp[0][0] = 1; // dp 배열 초기화

      // 게임판 이차원배열에 숫자 입력 받기
      StringTokenizer st;
      for (int i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine(), " ");
         for (int j = 0; j < N; j++) {
            gameArr[i][j] = Integer.parseInt(st.nextToken());
         }
      }

      for (int i = 0; i < N; i++) { // 게임 배열, dp 배열 모두 N만큼의 크기
         for (int j = 0; j < N; j++) {
            if(gameArr[i][j] != 0 && dp[i][j] != 0) {
               int move = gameArr[i][j]; // 움직일 수 있는 값 : gameArr[i][j] 만큼

               if(gameArr[i][j] + i < N){ // 아래로 이동하는 경우
                  dp[i + move][j] = dp[i][j] + dp[i + move][j]; // 원 거리 + 움직이고자 하는 거리
               }

               if(gameArr[i][j] + j < N){ // 오른쪽으로 이동하는 경우
                  dp[i][j + move] = dp[i][j] + dp[i][j + move];
               }
            }
         }
      }
      System.out.println(dp[N-1][N-1]); // 가장 오른쪽 값 출력

      // 배열 출력 테스트
      for (int i = 0; i < dp.length; i++) {
         for (int j = 0; j < dp[i].length; j++) {
            System.out.print(dp[i][j]);
         }
         System.out.println();
      }
   }
}
