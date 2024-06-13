package binary_search;

import java.io.*;
import java.util.*;

class B1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int cardNum = Integer.parseInt(br.readLine()); // 숫자카드 개수
            int[] cardArr = new int[cardNum]; // 숫자카드 담을 배열

            StringTokenizer st = new StringTokenizer(br.readLine(), " "); // String 받아오기
            for(int i = 0; i < cardNum; i++) {
                cardArr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(cardArr);

            int M = Integer.parseInt(br.readLine()); // 찾을 카드의 개수
            st = new StringTokenizer(br.readLine(), " ");

            StringBuilder sb = new StringBuilder(); // 결과값 담아줄 StringBuilder 선언

            for (int i = 0; i < M; i++) {
                int findCard = Integer.parseInt(st.nextToken());
                sb.append(binarySearch(cardArr, findCard)).append(" ");
            }
        System.out.println(sb);
    }

    public static int binarySearch(int[] cardArr, int findCard) { // 이진탐색 메서드
        int min = 0;
        int max = cardArr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            // 찾는 값이 중간보다 클때
            if (findCard > cardArr[mid] ) {
                min = mid + 1;

            // 찾는 값이 중간 보다 작을때
            } else if (findCard < cardArr[mid]) {
                max = mid - 1;

             // 찾는 값과 일치하는 경우
            } else {
                return 1;
            }
        }
        // 찾는 값이 없는 경우
        return 0;
    }
}