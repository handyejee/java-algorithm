package bakjoon.bronze.b1929;

import java.util.Scanner;

public class B1929withoutFunction {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        // 연산
        // 소수(2와 자기자신 -1 사이에 나눠지는 수가 있으면 소수가 아니다라는 조건 이용)

        for (int number = M; number <= N; number++) {
            boolean isPrime = true;

            if (number < 2) {
                isPrime = false;
            }

            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.println(number);
            }
        }
    }
}
