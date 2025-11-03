package bakjoon.gold.b1806;

import java.io.*;
import java.util.*;

public class B1806 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] numberArray = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numberArray[i] = Integer.parseInt(st.nextToken());
        }

        // 연산
        int start = 0;
        int end = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        while (true) {
            // 합이 S 이상이면 -> 시작점 이동 (구간 줄이기)
            if (currentSum >= S) {
                minLength = Math.min(minLength, end - start);
                currentSum -= numberArray[start];
                start++;
            }
            // 합이 S 미만이면 -> 끝점 이동 (구간 늘리기)
            else if (end < N) {
                currentSum += numberArray[end];
                end++;
            }

            else {
                break;
            }
        }
        // 출력
        if (minLength == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(minLength);
        }
    }
}
