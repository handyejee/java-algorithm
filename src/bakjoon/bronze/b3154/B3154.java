package bakjoon.bronze.b3154;

import java.io.*;
import java.util.*;

public class B3154 {

    static int[][] keyArr = {
            {3, 1},
            {0, 0},
            {0, 1},
            {0, 2},
            {1, 0},
            {1, 1},
            {1, 2},
            {2, 0},
            {2, 1},
            {2, 2}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        int T = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 연산
        int minEffort = Integer.MAX_VALUE;
        int resultH = 0;  // 답이 될 시간 입력값
        int resultM = 0;  // 답이 될 분 입력값

        // 입력받은 값과 일치하는 방법들을 모두 찾기
        for (int h = 0; h < 100; h++) {
            for (int m = 0; m < 100; m++) {
                if (h % 24 != T || m % 60 != M) {
                    continue;
                }

                // 일치하는 숫자를 만드는 경우, 노력값 계산
                int effort = calc(h / 10, h % 10) + calc(h % 10, m / 10) + calc(m  / 10, m % 10);

                if (effort < minEffort) {
                    minEffort = effort;
                    resultH = h;
                    resultM = m;
                }
            }
        }
        sb.append(resultH < 10 ? "0" : "").append(resultH)
                .append(resultM < 10 ? ":0" : ":").append(resultM);

        System.out.println(sb);
    }

    private static int calc(int a, int b) {
        return Math.abs(keyArr[a][0] - keyArr[b][0]) + Math.abs(keyArr[a][1] - keyArr[b][1]);
    }
}
