package bakjoon.bronze.b2490;

import java.util.Scanner;

public class B2490 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            int[] array = new int[4];
            for (int j = 0; j < 4; j++) {
                array[j] = sc.nextInt();
            }

            int backCount = 0;
            for (int j = 0; j < 4; j++) {
                if (array[j] == 0) {
                    backCount++;
                }
            }

            char[] results = {'E', 'A', 'B', 'C', 'D'};
            System.out.println(results[backCount]);
        }
    }
}
