package bakjoon.bronze.b2966;

import java.util.Scanner;

public class B2966 {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        char[] answers = sc.next().toCharArray();

        char[] adrianPattern = {'A','B','C'};
        char[] brunoPattern = {'B','A','B','C'};
        char[] goranPattern = {'C','C','A','A','B','B'};

        int adrianCount = 0;
        int brunoCount = 0;
        int goranCount = 0;

        // 연산
        for (int i = 0; i < N; i++) {
            if (answers[i] == adrianPattern[i%3]) {
                adrianCount++;
            }
            if (answers[i] == brunoPattern[i%4]) {
                brunoCount++;
            }
            if (answers[i] == goranPattern[i%6]) {
                goranCount++;
            }
        }

        int maxScore = Math.max(adrianCount, Math.max(brunoCount, goranCount));
        System.out.println(maxScore);

        if (maxScore == adrianCount) {
            System.out.println("Adrian");
        }
        if (maxScore == brunoCount) {
            System.out.println("Bruno");
        }
        if (maxScore == goranCount) {
            System.out.println("Goran");
        }

    }
}
