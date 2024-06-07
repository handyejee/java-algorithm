package queue;

import java.util.PriorityQueue;
import java.util.Collections;

class Process {
    public int solution(int[] priorities, int location) {
        // 우선순위 큐 선언(내림 차순) -> 우선순위 높은 것 부터 정렬하기 위해 reverseOrder 사용
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for (int pri : priorities) { // 우선순위 큐에 값 추가
            queue.offer(pri);
        }

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            // 기존 우선순위 배열 순회
            for (int i = 0; i < priorities.length; i++) {

                if (queue.peek() == priorities[i]) { // 큐 맨처음 뺀 값 과 priority 인덱스 비교
                    queue.poll();
                    answer++;

                    // 현재 작업이 location과 같으면 answer 반환
                    if (location == i) {
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}