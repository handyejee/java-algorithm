package bakjoon.b13458;

import java.io.*;
import java.util.*;

public class B13458 {
    public static void main(String[] args) throws IOException {
        // 시험장 개수 N
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        // 응시자 수
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 감독관
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long count = N;

        for (int i = 0; i < N; i++) {
            int leftStudent = A[i] - B;
            if (leftStudent > 0) {
                count += (long) Math.ceil((double)leftStudent / C);
            }
        }
        System.out.println(count);
    }
}
