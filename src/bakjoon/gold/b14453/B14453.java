package bakjoon.gold.b14453;

import java.io.*;

public class B14453 {
    public static void main(String[] args) throws IOException {
        // 게임 총 횟수 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] prefix = new int[3][N + 1];

        // 배열에 gesture 입력받기
        for (int i = 1; i <= N; i++) {
            char input = br.readLine().charAt(0);

            // 누적합을 위해 이전 값을 복사한다
            for (int j = 0; j < 3; j++) {
                prefix[j][i] = prefix[j][i - 1];
            }

            // gesture이 P, H, S 인 경우 배열에 추가
            if (input == 'P') prefix[0][i]++;
            else if (input == 'H') prefix[1][i]++;
            else if (input == 'S') prefix[2][i]++;
        }

        int maxWins = 0;

        for (int first = 0; first < 3; first++) {
            for (int second = 0; second < 3; second++) {

                for (int split = 0; split <= N ; split++) {
                    int frontWins = prefix[first][split];
                    int backWins = prefix[second][split];
                    maxWins = Math.max(maxWins, frontWins + backWins); // 앞 gesture 승리 횟수 + 뒷 gesture 승리횟수 최댓값 비교
                }
            }
        }
        System.out.println(maxWins);
    }
}
