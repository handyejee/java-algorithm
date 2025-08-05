package bakjoon.bronze.b2562;

import java.util.Scanner;

public class B2562 {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int[] array = new int[9];
        int maxNum = 0;
        int index = 0;

        for (int i = 0; i < 9; i++) {
            array[i] = sc.nextInt();
            maxNum = Math.max(maxNum, array[i]);
            if (array[i] == maxNum) {
                index = i;
            }
        }

        // 출력
        System.out.println(maxNum);
        System.out.println(index + 1);
    }
}
