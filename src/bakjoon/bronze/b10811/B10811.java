package bakjoon.bronze.b10811;

import java.util.Scanner;

public class B10811 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int N = sc.nextInt();
        int[] array = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            array[i] = i;
        }

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            while (start <= end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;

                start++;
                end--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(array[i]).append(" ");
        }
        System.out.println(sb);
    }
}
