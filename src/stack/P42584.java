package stack;

import java.util.Stack;
class P42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int [prices.length]; // 가격 떨어지지 않은 기간 저장할 배열

        Stack<Integer> stack = new Stack<>();
        stack.push(0); // 초기값 0

        for(int i = 1; i< prices.length; i++){
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]){ // 주식 가격이 떨어지는 경우
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int index = stack.pop();
            answer[index] = prices.length - 1 - index;
        }
        return answer;
    }
}
