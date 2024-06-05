package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T --> 0) {
            String sentence = br.readLine() + '\n'; // 마지막 문자 처리하기 위해 더해줌
            System.out.println(sentence);
            Stack<Character> stack = new Stack<>();

            for(Character c : sentence.toCharArray()){
                if (c == ' ' || c == '\n'){ // 공백이거나 줄바꿈일 경우
                    while (!stack.isEmpty()){ // 스택이 비어있지 않으면
                        sb.append(stack.pop()); // 스택에서 꺼내서 sb에 추가
                    }
                    sb.append(c); // 공백, 줄바꿈 추가
                } else {
                    stack.push(c); // 그 외의 경우 스택에 추가
                }
            }
        }
        System.out.println(sb);
    }
}
