package bakjoon.silver.b2529;

import java.io.*;
import java.util.*;

public class B2529 {
    static int k;
    static char[] operators;
    static boolean[] used = new boolean[10];
    static List<String> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        operators = new char[k];
        for (int i = 0; i < k; i++) {
            operators[i] = st.nextToken().charAt(0);
        }

        for (int i = 0; i <= 9; i++) {
            used[i] = true;
            backtrack(i , 0, i + "");
            used[i] = false;
        }

        System.out.println(results.get(results.size() - 1)); // 최댓값
        System.out.println(results.get(0)); // 최솟값
    }

    static void backtrack(int currentNum, int depth, String number){
        if (depth == k) {
            results.add(number);
            return;
        }

        for (int nextNum = 0; nextNum <= 9 ; nextNum++) {
            if (!used[nextNum] && isValidChoice(currentNum, nextNum, operators[depth])) {
                used[nextNum] = true;

                backtrack(nextNum, depth + 1, number + nextNum);

                used[nextNum] = false;
            }
        }
    }

    private static boolean isValidChoice(int prev, int next, char operator) {
        if (operator == '<') {
            return prev < next;
        } else {
            return prev > next;
        }
    }
}
