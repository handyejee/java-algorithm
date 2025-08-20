package bakjoon.bronze.b1929;

import java.util.Scanner;

public class B1929 {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        // 연산
        for (int number = M; number <= N ; number++) {
            if (isPrime(number)) {
                System.out.println(number);
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
