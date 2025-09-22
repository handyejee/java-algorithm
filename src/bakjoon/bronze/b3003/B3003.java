package bakjoon.bronze.b3003;

import java.io.*;
import java.util.*;

public class B3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] originalPieces = {1, 1, 2, 2, 2, 8};
        int[] input = new int[6];
        int[] answer = new int[6];

        for (int i = 0; i < 6; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            answer[i] = originalPieces[i] - input[i];
        }

        for (int piece : answer) {
            System.out.print(piece + " ");
        }
    }
}
