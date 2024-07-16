package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class B1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (queue.size() > 1){
            for (int i = 0; i < K - 1 ; i++) {
                queue.add(queue.poll());
            }
            sb.append(queue.pollFirst()).append(", ");
        }

        sb.append(queue.poll()).append(">");
        System.out.print(sb);
    }
}
