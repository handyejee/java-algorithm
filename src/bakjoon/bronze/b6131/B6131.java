package bakjoon.bronze.b6131;

import java.util.Scanner;

public class B6131 {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        // 연산
        int count = 0;
        for (int A = 1; A <= 500 ; A++) {
            for (int B = 1; B <= A ; B++) {
                if ((A * A) - (B * B) == N) {
                    count++;
                }
            }
        }

        // 출력
        System.out.println(count);
    }
}