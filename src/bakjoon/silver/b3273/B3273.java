package bakjoon.silver.b3273;

import java.io.*;
import java.util.*;

public class B3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(array); // 배열 정렬

        int left = 0;
        int right = n - 1;
        int count = 0;

        while (left < right) {
            int sum = array[left] + array[right];
            if (sum == x) {
                count++;
                left++;
                right--;
            } else if (sum < x) {
                left++; // 합이 작은경우 더 큰 수 필요
            } else {
                right--; // 합이 더 큰 경우 더 작은수 필요
            }
        }
        System.out.println(count);
    }
}
