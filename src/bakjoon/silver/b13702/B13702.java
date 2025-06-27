package bakjoon.silver.b13702;

import java.util.*;
import java.io.*;
public class B13702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 막걸리 용량, 나눠마실 친구 입력받기
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 각각 용량 입력받을 배열 선언 하고 막걸리 용량 중 최댓값 구하기
        long[] liquors = new long[N];
        long maxVolumn = 0;
        for (int i = 0; i < N; i++) {
            liquors[i] = Long.parseLong(br.readLine());
            maxVolumn = Math.max(maxVolumn, liquors[i]);
        }

        // 이분탐색
        // 막걸리 용량들을 순회하면서 중간 값으로 나눴을때 K 보다 큰지를 찾기
        long start = 0, end = maxVolumn, result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for (long liquor : liquors) {
                sum += (liquor / mid);
            }

            if (sum >= K) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}
