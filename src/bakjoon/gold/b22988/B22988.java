package bakjoon.gold.b22988;

import java.util.*;
import java.io.*;

public class B22988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 에센스 수(N), 에센스 용기 총 용량(X)
        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());
        List<Long> containers = new ArrayList<>();
        int answer = 0;

        // X에 도달한 수는 제외하고 에센스 용량 입력받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long capacity = Long.parseLong(st.nextToken());
            if (capacity == X) {
                answer++;
            } else {
                containers.add(capacity);
            }
        }

        // 용기 교환하기
        while (containers.size() >= 2) { // 용기 교환은 2개부터 할 수 있다
            Collections.sort(containers);
            List<Long> nextRound = new ArrayList<>();

            int left = 0;
            int right = containers.size() - 1;

            while (left < right) {
                // 용기 교환 결과를 계산
                long newCapacity = Math.min(
                        containers.get(left) + containers.get(right) + X / 2 , X);
                if (newCapacity == X) {
                    answer++;
                } else {
                    nextRound.add(newCapacity);
                }

                left++; // 포인터 이동
                right--;
            }

            // 가운데 하나 남은 홀수의 경우
            if (left == right) {
                nextRound.add(containers.get(left));
            }

            containers = nextRound;
        }
        System.out.println(answer);
    }
}
