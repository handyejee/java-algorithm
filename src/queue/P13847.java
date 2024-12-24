package queue;

import java.util.PriorityQueue;

public class P13847 {

  public int[] solution(int k, int[] score) {
    int[] answer = new int[score.length];

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int i = 0; i < score.length; i++) {

      pq.offer(score[i]); // add는 Illegal State Exception 발생

      if (pq.size()  > k) {
        pq.poll(); // 가장 작은 값 제거
      }

      answer[i] = pq.peek();
    }

    return answer;
  }
}
