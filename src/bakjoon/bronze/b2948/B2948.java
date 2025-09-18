package bakjoon.bronze.b2948;

import java.util.Scanner;

public class B2948 {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt(); // 일
        int M = sc.nextInt(); // 월

        // 월별 날짜
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 요일
        String[] days = {"Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday"};


        // 연산
        int totalDays = 0;

        for (int i = 0; i < M - 1 ; i++) {
            totalDays += daysInMonth[i];
        }

        totalDays += (D - 1);

        // 출력
        String day = days[totalDays % 7]; // 날짜에서 요일을 구해서 요일 배열에서 가져온다
        System.out.println(day);

    }
}
