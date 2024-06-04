package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class B9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 데이터

        for (int i = 0; i < T; i++) {
            String PS = br.readLine(); // 괄호 문자열 입력받기
            Stack<Character> stack = new Stack<>(); //  character 제네릭 선언
            boolean flag = true;

            for (int j = 0; j < PS.length(); j++) { // 문자열의 길이만큼 반복
                char c = PS.charAt(j) ; // 한글자씩 확인하기 위해큐 charAt 사용

                if (c == '(') { // 여는 괄호 일 경우 스택에 넣음
                    stack.push(c);
                } else { // 닫힌 괄호가 들어오는 경우
                    if (stack.isEmpty()) { // 닫힌 괄호만 들어온 경우
                        flag = false;
                        break; // 더이상 반복 하지 않음
                    }
                    else { // 짝이 맞는 경우
                        stack.pop();
                    }
                }
            }
            if (!stack.isEmpty()){ // 짝이 안맞는 열린 괄호가 있는 경우
                flag = false;
            }
            String result = flag ? "YES" : "NO";
            System.out.println(result);
        }
    }
}
