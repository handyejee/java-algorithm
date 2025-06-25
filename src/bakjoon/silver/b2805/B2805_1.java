package bakjoon.silver.b2805;

import java.io.*;
import java.util.*;

public class B2805_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] trees = new int[N];

        int maxHeight = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, trees[i]);
        }

        int start = 0, end = maxHeight, result = 0;
        while (start < end) {
            int mid = (start + end) / 2; // 중간값

            int sum = 0;
            for (int tree : trees) {
                sum += (tree - mid);
            }

            if (sum >= M) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        System.out.println(result);
    }
}
