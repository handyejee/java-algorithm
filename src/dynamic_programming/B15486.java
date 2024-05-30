package dynamic_programming;

import java.io.*;
import java.util.StringTokenizer;

public class B15486 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        int[][] arr =new int[n+2][2];
        int[] dp = new int[n+2];
        for(int i=1; i<n+1; i++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());
            arr[i][0] = time;
            arr[i][1] = pay;
        }

        int max = -1;
        for(int i=1; i<=n+1; i++) {
            if(max < dp[i]) {
                max = dp[i];
            }

            int nxt = i +arr[i][0];
            if(nxt < n+2) {
                dp[nxt] = Math.max(dp[nxt], max+arr[i][1]);
            }
        }
        System.out.println(dp[n+1]);
    }
}
