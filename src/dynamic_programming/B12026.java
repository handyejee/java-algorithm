package dynamic_programming;

import java.util.Scanner;
import java.util.Arrays;

public class B12026 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String block = scanner.next();
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (dp[i] == Integer.MAX_VALUE) {
                    continue;
                }

                int min = Math.min(dp[i] + (j - i) * (j - i), dp[j]);
                if (block.charAt(i) == 'B' && block.charAt(j) == 'O') {
                    dp[j] = min;
                }

                if (block.charAt(i) == 'O' && block.charAt(j) == 'J') {
                    dp[j] = min;
                }

                if (block.charAt(i) == 'J' && block.charAt(j) == 'B') {
                    dp[j] = min;
                }
            }
        }

        if (dp[n - 1] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n - 1]);
        }
    }
}