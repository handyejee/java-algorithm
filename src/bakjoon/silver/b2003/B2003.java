package bakjoon.silver.b2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2003 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken(br.readLine()));
        int M = Integer.parseInt(st.nextToken(br.readLine()));

        int[] numberArray = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numberArray[i] = Integer.parseInt(st.nextToken());
        }

        // 배열에서 원소 탐색
        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;

        // 탐색 조건

        while (right < N) {
           sum += numberArray[right];

            while(sum > M) {
                sum -= numberArray[left];
            }

            if (sum == M) {
                count++;
            }

            right++;
        }
        System.out.println(count);
    }
}
