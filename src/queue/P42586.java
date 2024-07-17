package queue;

import java.util.Queue;
import java.util.ArrayDeque;

class P42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> answer = new ArrayDeque<>();

        int day = progresses.length; // 작업 개수

        int[] daysLeft = new int[day]; // 남은 작업일수 담을 배열

        for (int i = 0; i < day; i++) {
            daysLeft[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]); // 남은 작업일 수 계산식
        }

        int count = 0;
        int latest = daysLeft[0];

        for (int i = 0; i < day; i++) {
            if (daysLeft[i] <= latest) {
                count++;

            } else {
                answer.add(count);
                count = 1;
                latest = daysLeft[i];
            }
        }

        answer.add(count);
        return answer.stream().mapToInt(Integer::intValue).toArray(); // 큐에 담아줬던 값 배열로 반환

    }
}
