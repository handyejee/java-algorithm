package bakjoon.bronze.b2738;

import java.util.Scanner;

public class B2738 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 행의 개수
        int M = sc.nextInt(); // 열의 개수

        // 행렬 A, B 선언
        int[][] A = new int[N][M];
        int[][] B = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(A[i][j] + B[i][j]);
                if (j < M - 1) {
                    System.out.print(" "); // 마지막 원소가 아니면 공백 추가
                }
            }
            System.out.println(); // 한 행이 끝나면 줄바꿈
        }
    }
}
