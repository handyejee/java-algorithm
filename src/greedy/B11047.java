package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 동전 종류 개수
        int K = Integer.parseInt(st.nextToken()); // 만들수 있는 돈

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (coins[i] <= K ){
                cnt += (K / coins[i]);
                K = K % coins[i];
            }
        }
        System.out.println(cnt);
    }
}
