package bakjoon.bronze.b6750;

import java.util.Scanner;

public class B6750 {
    public static void main(String[] args) {
        String validLetters = "IOSHZXN";

         // 입력
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        // 연산
        for (char c : word.toCharArray()) {
            if (validLetters.indexOf(c) == -1) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
