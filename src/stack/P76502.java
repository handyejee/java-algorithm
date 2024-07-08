package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



class Solution {
    public int solution(String s) {
        int answer = 0;
        Queue<Character> queue = new LinkedList<>();

        for (char c : s.toCharArray()) {
            queue.offer(c);
        }
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < s.length(); j++) {

                char c = queue.poll();
                queue.offer(c);

                if (stack.isEmpty()) {
                    stack.push(c);
                } else if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(c); // 짝을 못 찾은 닫힌 괄호
                }
            }

            if (stack.isEmpty()) {
                answer++;
            }

            queue.offer(queue.poll());
        }

        return answer;
    }
}
