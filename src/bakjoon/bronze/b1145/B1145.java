package bakjoon.bronze.b1145;

import java.io.*;
import java.util.*;

public class B1145 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] array = new int[5];
        for (int i = 0; i < 5 ; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // 연산
        Arrays.sort(array);

        int upper = lcm3(array[0], array[1], array[2]);

        for (int i = 0; i <= upper; i++) {
            int count = 0;
            for (int num : array) {
                if (i % num == 0) count++;
            }

            if (count >= 3) {
                System.out.println(i);
                break;
            }
        }
    }

    public static int gcd(int a, int b) { // 최대공약수
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) { // 최소공배수
        return (a * b) / gcd(a, b);
    }

    public static int lcm3(int a, int b, int c) {
        return lcm(lcm(a, b), c);
    }
}
