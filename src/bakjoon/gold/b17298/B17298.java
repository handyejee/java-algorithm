package bakjoon.gold.b17298;

import java.util.*;
import java.io.*;
public class B17298 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // 연산
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[N];

        // 배열 순회
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && array[stack.peek()] < array[i]) {
                int idx = stack.pop();
                result[idx] = array[i];
            }
            stack.push(i);
        }

        // 더 큰수가 없는 경우
        while(!stack.isEmpty()) {
            int idx = stack.pop();
            result[idx] = -1;
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
