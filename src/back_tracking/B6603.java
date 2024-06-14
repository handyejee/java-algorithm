package back_tracking;

import java.io.*;
import java.util.*;

public class B6603 {
    static int k;
    static int[] S, numbers;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());
            if (k == 0) break; // k가 0이면 종료

            S = new int[k]; // k개의 숫자 저장할 배열
            numbers = new int[6]; // 조합 생성할때 임시 저장할 배열

            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken()); // k개 숫자 입력 받아 저장
            }

            combi(0, 0); // combi 메서드 호출해서 조합 생성

            sb.append("\n"); // 한줄씩 출력해주기 위해서 \n 추가
        }

        System.out.println(sb);
    }

    private static void combi(int cnt, int start) { // 시작 인덱스
        if (cnt == 6) { // 탈출조건 : 6개의 숫자를 모두 선택한 경우
            for (int i = 0; i < 6; i++) {
                sb.append(numbers[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < k; i++) {
            numbers[cnt] = S[i]; // 현재 인덱스 i의 숫자를 선택해 numbers 배열 cnt에 저장
            combi(cnt + 1, i + 1); // 재귀 호출
            //cnt 1 증가, start를 i + 1로 업데이트 : 중복 피하기 위해
        }
    }
}
