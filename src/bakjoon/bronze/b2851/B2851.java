package bakjoon.bronze.b2851;

import java.util.*;

public class B2851 {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int[] numberArray = new int[10];

        for (int i = 0; i < 10 ; i++) {
           numberArray[i] = sc.nextInt();
        }

        // 연산
        int currentSum = 0;
        int answer = currentSum;

        for (int i = 0; i < numberArray.length ; i++) {
            currentSum += numberArray[i];

            if (Math.abs(currentSum - 100) < Math.abs(answer - 100)) {
                answer = currentSum;
            } else if (Math.abs(currentSum - 100) == Math.abs(answer - 100)) {
                answer = Math.max(currentSum, answer);
            }
        }

        // 출력
        System.out.println(answer);
    }
}
