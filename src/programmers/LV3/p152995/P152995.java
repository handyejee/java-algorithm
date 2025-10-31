package programmers.LV3.p152995;

import java.util.Arrays;

public class P152995 {
    public int solution(int[][] scores) {
        // 완호의 점수
        int wAttitude = scores[0][0];
        int wPeerReview = scores[0][1];
        int wScore = wAttitude + wPeerReview;

        // 근무태도 내림차순 동료 평가 오름차순 정렬
        Arrays.sort(scores, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });

        int maxPeerReview = 0; // 최대 동료평가
        int wRank = 1;  // 완호의 순위

       for (int[] score : scores) {
           // 완호 탈락여부
           if (wAttitude < score[0] && wPeerReview < score[1]) {
               return -1;
           }

           // 탈락자는 석차계산 제외
           if (score[1] < maxPeerReview) {
               continue;
           }

           // 동료평가 최대값 구하기
           maxPeerReview = Math.max(maxPeerReview, score[1]);

           // 석차 계산
           int sum = score[0] + score[1];
           if (sum > wScore) {
               wRank++;
           }
       }
        return wRank;
    }
}
