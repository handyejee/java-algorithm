package bakjoon.gold.b1644;

import java.util.*;

public class B1644 {
    public static void main(String[] args) {
        // 자연수 N 입력받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 소수 구하기
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i * i <= N; i++) {
            if(isPrime[i]) {
                for(int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 소수를 소수리스트에 담아주기
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        // 연속된 소수의 합이 N인 경우 구하기
        int left = 0, right = 0, count = 0, sum = 0;
        while (right < primes.size()) {
            sum += primes.get(right);

            while (sum > N) {
                sum -= primes.get(left);
                left++;
            }

            if (sum == N) count++;
            right++;
        }
        System.out.println(count);
    }
}
