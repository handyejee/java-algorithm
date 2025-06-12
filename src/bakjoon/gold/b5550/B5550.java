package bakjoon.gold.b5550;

import java.io.*;
import java.util.*;

public class B5550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 책의 개수, 팔려고 하는 책 입력받기
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 1-10 장르별로 입력하기 위한 외부 arraylist 선언
        List<List<Integer>> genreList = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            genreList.add(new ArrayList<>());
        }

        // 내부 arraylist에 장르별 책 가격 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int genre = Integer.parseInt(st.nextToken());

            genreList.get(genre).add(price); // 장르별 가격 입력
        }

        // 장르 내 가격 내림차순 정렬
        for (int i = 1; i <= 10; i++) {
            genreList.get(i).sort(Collections.reverseOrder());
        }

        // 2차원 DP생성
        long[][] dp = new long[11][K + 1];

        for (int genre = 1; genre <= 10; genre++) {
            List<Integer> currentGenre = genreList.get(genre);

            // 이전 장르 결과 복사
            for (int books = 0; books <= K; books++) {
                dp[genre][books] = dp[genre - 1][books];
            }

            int maxSelect = Math.min(currentGenre.size(), K);

            for (int select = 1; select <= maxSelect; select++) {
                long profit = calculateProfit(currentGenre, select);

                for (int totalBooks = select; totalBooks <= K; totalBooks++) { // 점화식
                    dp[genre][totalBooks] = Math.max(dp[genre][totalBooks],
                            dp[genre - 1][totalBooks - select] + profit);
                }

            }
        }
        System.out.println(dp[10][K]);
    }

    // 장르에서 수익 구하는 메서드
    private static long calculateProfit(List<Integer> books, int count) {
        long total = 0;
        for (int i = 0; i < count; i++) {
            total += books.get(i) + (count - 1);  // 기준가격 + 보너스
        }
        return total;
    }
}
