package programmers.LV1.P42840;

import java.util.ArrayList;

public class P42840 {
    public static int[] solution(int[] answers) {

        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern1[i % pattern1.length]) scores[0]++;
            if (answers[i] == pattern2[i % pattern2.length]) scores[1]++;
            if (answers[i] == pattern3[i % pattern3.length]) scores[2]++;
        }

        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (scores[i] == maxScore) {
                list.add(i);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
