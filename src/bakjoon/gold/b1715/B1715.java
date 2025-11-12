package bakjoon.gold.b1715;

import java.io.*;
import java.util.PriorityQueue;

public class B1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N ; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int totalComparisons = 0;
        while (pq.size() > 1) {
            // 1. 가장 작은 2개 꺼내기
            int a = pq.poll();
            int b = pq.poll();

            // 2. 합치기
            int sum = a + b;

            // 3. 비용 누적
            totalComparisons += sum;

            // 4. 합친 값 다시 넣기
            pq.offer(totalComparisons);
        }

        System.out.println(totalComparisons);
    }
}
