package bakjoon.bronze.b11328;

import java.util.Arrays;
import java.util.Scanner;

public class B11328 {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String[] words  = sc.nextLine().split(" "); // 한번에 입력 받아서 단어 두개를 배열 하나에 넣어줌
            String wordA = words[0];
            String wordB = words[1];

            // 연산
            // 알파벳 배열에 넣어서 인덱스를 더해줌
            int[] countA = new int[26];
            for (char c : wordA.toCharArray()) {
                int index = c - 'a';
                countA[index]++;
            }
            
            int[] countB = new int[26];
            for (char c : wordB.toCharArray()){
                int index = c - 'a';
                countB[index]++;
            }

            // 두개배열 비교
            // 출력
            if (Arrays.equals(countA, countB)) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
    }
}
