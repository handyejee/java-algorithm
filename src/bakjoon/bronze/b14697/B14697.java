package bakjoon.bronze.b14697;

import java.io.*;
import java.util.*;

public class B14697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 연산
        for (int roomA = 1; roomA <= N / A ; roomA++) {
            int afterA = N - A * roomA;

            for (int roomB = 0; roomB < B / N; roomB++) {
                int afterB = N - B * roomB;

                if(afterB % C == 0) {
                    System.out.println(1);
                    break;
                }
            }
        }

        System.out.println(0);
    }
}
