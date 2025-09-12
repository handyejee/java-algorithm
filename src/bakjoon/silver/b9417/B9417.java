package bakjoon.silver.b9417;

import java.io.*;
import java.util.*;

public class B9417 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 테스트케이스 수

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int tc = 0; tc < N; tc++) {
            numbers.clear();
            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) { // 한줄에 여러개의 숫자를 넣기 위해 hasMoreTokens 사용
                numbers.add(Integer.parseInt(st.nextToken()));
            }

            // 연산
            int max = 0;
            for (int i = 0; i < numbers.size(); i++) {
                for (int j = i + 1; j < numbers.size(); j++) {
                    int num = gcd(numbers.get(i), numbers.get(j));
                    max = Math.max(num, max);
                }
            }
            // 출력
            bw.write(max + "\n");
        }
        // 출력
        bw.flush();
        bw.close();
        br.close();
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int remainder = a % b;

            a = b;
            b = remainder;
        }
        return a;
    }
}
