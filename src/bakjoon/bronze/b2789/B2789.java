package bakjoon.bronze.b2789;

import java.io.*;

public class B2789 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputWord = br.readLine();
        char[] word = inputWord.toCharArray();

        char[] charArray = "CAMBRIDGE".toCharArray();

        // 연산
        StringBuilder result = new StringBuilder();

        for (char c : word) {
            boolean found = false;
            for (char value : charArray) {
                if (c == value) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                result.append(c);
            }

        }

        // 출력
        System.out.println(result);

    }
}
