package bakjoon.bronze.b14568;

import java.util.*;

public class B14568 {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 연산
        int count = 0;

        for (int A = 2; A < N ; A += 2) { // A는 1보다 큰 짝수
            for (int B = 1; B < N - A; B++) { // B는 0보다 큰 수
                int C = N - A - B;
                if (C >= B + 2) { // C는 B보다 2이상 큰 수
                    count++;
                }
            }
        }

        // 출력
        System.out.println(count);
    }
}
