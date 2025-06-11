package bakjoon.gold.b2015;

import java.util.*;
import java.io.*;

public class B2015 {
    public static void main(String[] args) throws IOException {
        // N, K 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 배열A 에 N개의 정수 넣어주기
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 누적합 0을 1개로 초기화한다
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);

        long prefixSum = 0;
        long result = 0;

        for (int i = 0; i < N; i++) {
            // 현재 원소를 누적합에 더한다
            prefixSum += A[i];

            // (현재 누적합 - K) 값이 몇번 나타났는지 확인해 결과에 더한다
            result += map.getOrDefault(prefixSum - K, 0);

            // 현재 누적합을 HashMap에 기록한다
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        System.out.println(result); // 결과 출력
    }
}
