package queue;

import java.util.Queue;
import java.util.ArrayDeque;

class P159994 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        Queue<String> card1que = new ArrayDeque<>();
        Queue<String> card2que = new ArrayDeque<>();
        Queue<String> goalque = new ArrayDeque<>();

        for (String c1 : cards1){ // 큐에 card. goal 값 넣어주기
            card1que.offer(c1);
        }

        for (String c2 : cards2){
            card2que.offer(c2);
        }

        for (String goals : goal){
            goalque.offer(goals);
        }

        while(!goalque.isEmpty()){
            if(!card1que.isEmpty() && card1que.peek().equals(goalque.peek())){
                card1que.poll();
                goalque.poll();

            }else if(!card2que.isEmpty() && card2que.peek().equals(goalque.peek())){
                card2que.poll();
                goalque.poll();
            } else{
                break;
            }
        }

        return goalque.isEmpty()? "Yes": "No";
    }
}
