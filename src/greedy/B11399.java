package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class B11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 사람 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        // StringTokenizer는 초기화 시점에 지정된 입력 줄을 기준으로 토큰을 나누기 때문에, 적절한 데이터가 전달되도록 초기화 순서를 맞춰야 힌다.

        int[] pArr = new int[N];

        for (int i = 0; i < N; i++) {
            pArr[i] = Integer.parseInt(st.nextToken()); // 각 사람이 인출하는데 걸리는 시간
        }
        Arrays.sort(pArr);

        int sum = 0;
        int total = 0;

        for (int i = 0; i < N; i++) {
            sum += pArr[i];
            total += sum;
        }
        System.out.println(total);
    }
}
