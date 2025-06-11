package bakjoon.gold.b2143;

import java.io.*;
import java.util.*;

public class B2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // A 배열과 원소 입력 받기
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // B 배열과 원소 입력 받기
        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // A 배열의 모든 부배열 합 구하기
        ArrayList<Integer> sumAList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += A[j];
                sumAList.add(sum);
            }
        }

        // B 배열의 모든 부배열 합 구하기
        ArrayList<Integer> sumBList = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            int sum = 0;
            for(int j = i; j < m; j++) {
                sum += B[j];
                sumBList.add(sum);
            }
        }

        // A의 합 + B의 합 = T가 되는 경우의 수 구하기
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int sumA : sumAList) {
            map.put(sumA, map.getOrDefault(sumA, 0) + 1);
        }

        long count = 0;
        for (int sumB : sumBList) {
            int targetSumA = T - sumB;

            if (map.containsKey(targetSumA)) {
                count += map.get(targetSumA);
            }
        }
        System.out.println(count);
    }
}
