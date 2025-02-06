package programmers.LV2.P12909;

import java.util.Stack;

class P12909 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()){
            if(c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) { // 닫힌 괄호만 들어온 경우
                    return false;
                }
                else { // 짝이 맞는 경우
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
