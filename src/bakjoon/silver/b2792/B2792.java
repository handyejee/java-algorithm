package bakjoon.silver.b2792;

import java.io.*;
import java.util.*;

public class B2792 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] array = new int[M];
        int max = 0;

        for (int i = 0; i < M; i++) {
            array[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, array[i]); // 이분탐색 상한 값 계산
        }

        // 이분탐색
        int left = 1; // 최소 질투심
        int right = max; // 최대 질투심
        int result = 0; // 답을 저장할 변수

        while(left <= right) {
            int mid = left + (right - left) / 2;

            int count = 0;
            for (int i = 0; i < M; i++) {
                if (array[i] % mid == 0) {
                    count += array[i] / mid;
                } else {
                    count += array[i] / mid + 1;
                }
            }

            if (count > N) {
                left = mid + 1;
            } else {
                right = mid - 1;
                result = mid;
            }
        }
        System.out.println(result);
    }
}
