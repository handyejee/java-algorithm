package bakjoon.bronze.b13300;

import java.io.*;
import java.util.*;

public class B13330 {
    public static void main(String[] args) throws IOException {
        // 수학여행 참가 학생수, 한방에 배정할 인원수 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 학생 배열
        int[][] students = new int[2][6];

        // 참가하는 학생수 만큼 반복문으로 입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            // 성별과 학년 별 학생 수 담는 배열 
            students[gender][grade - 1]++;
        }
        
        int total = 0;

        for (int gender = 0; gender < 2; gender++) {
            for (int grade = 0; grade < 6; grade++) {
                int studentCount = students[gender][grade];

                if (studentCount > 0) {
                    int rooms = (studentCount + K - 1) / K;
                    total += rooms;
                }
            }
        }
        System.out.println(total);
    }
}
