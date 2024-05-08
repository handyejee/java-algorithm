package queue;

import java.util.*;

class PTruck {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();

        int sum = 0; // 트럭의 총 무게 구하기 위한 변수 선언
        int time = 0; // 트럭이 지나가는데 걸린 시간 구하기 위한 변수 선언

        for(int truck : truck_weights){ // 다리에 올라갈 수 있는 트럭 수 만큼 반복

            while(true){ // 트럭이 다리를 건너는 동안

                // 큐가 비어있는 경우
                if(queue.isEmpty()){
                    queue.offer(truck); // 큐에 트럭 추가 하기
//                    System.out.println(queue);
                    sum += truck; // 트럭 무게 더해주기
                    time++; // 시간 더하기
                    break;

                } else if (queue.size() == bridge_length){ // 큐가 가득찬 경우
                    sum -= queue.poll(); //큐에서 가장 먼저 들어온 값 제거 하면서 총 트럭 무게에서 빼주기
//                    System.out.println(queue);

                } else {  // 큐가 비어있지 않은 경우
                    if (sum + truck <= weight) { // 총 무게보다 들어오는 트럭 무게가 작다면
                        queue.offer(truck); // 큐에 트럭을 넣어줌
                        sum += truck; // 들어온 트럭에 트럭 무게 추가
                        time++; // 시간 추가
//                        System.out.println(queue);
                        break;
                    }
                    else {
                        queue.offer(0); // 총 무게가 트럭 무게보다 크다면
                        time++; // 시간 추가(시간은 흘러가니까)
                    }
                }
            }
        }
//        System.out.println("마지막큐" + queue);
        return time + bridge_length;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
    }
}


