package bakjoon.bronze.b10813;

import java.util.*;
public class B10813 {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] array = new int[N];
        for (int i = 0; i < N ; i++) {
            array[i] = i + 1;
        }

        // 연산
        for (int i = 1; i <= M ; i++) {
            int firstNum = sc.nextInt();
            int secondNum = sc.nextInt();

            int temp;
            temp = array[firstNum -1];
            array[firstNum -1] = array[secondNum - 1];
            array[secondNum - 1] = temp;
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
