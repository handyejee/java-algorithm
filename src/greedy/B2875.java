package greedy;

import java.io.*;
import java.util.*;

public class B2875 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 여학생
        int m = Integer.parseInt(st.nextToken()); // 남학생
        int k = Integer.parseInt(st.nextToken()); // 인턴참여

        int count = 0;
        while(true){
            n -= 2;
            m -= 1;

            if (n < 0 || m < 0 || n + m < k){
                break;
            }
            count += 1;
        }
        System.out.println(count);
    }

}