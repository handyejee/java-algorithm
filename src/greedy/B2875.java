package greedy;

import java.io.*;
import java.util.*;

public class B2875 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int team = 0;
        while (N >=2 && M >= 1 && (N + M) - K >= 3) {

            N -=2;
            M -=1;
            team++;
        }
        System.out.println(team);
    }

}