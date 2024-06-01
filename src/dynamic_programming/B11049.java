package dynamic_programming;

import java.util.Scanner;

public class B11049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dimensions = new int[n + 1];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dimensions[i] = sc.nextInt();
            dimensions[i + 1] = sc.nextInt();
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + dimensions[i] * dimensions[k + 1] * dimensions[j + 1];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        System.out.println(dp[0][n - 1]);
        sc.close();
    }
}
