package bfs_dfs;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class B2606 {
    static boolean[][] graph;
    static boolean[] visited;
    static int N, M;
    static int answer;

    public static void dfs(int index) {
        visited[index] = true;
        // for (int i = 1; i <= N; i++)과 동일
        IntStream.range(0, N).forEach(i -> { // 0부터 N-1까지 범위 반복해서 정수 생성
            if (!visited[i] && graph[index][i])
                dfs(i);
        });


        answer++; // dfs 함수가 호출되는 만큼
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new boolean[N][N]; // 인접행렬
        visited = new boolean[N]; // 방문한 배열
        int x, y;
        for (int i=0; i< M; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            x = Integer.parseInt(tokenizer.nextToken())-1;
            y = Integer.parseInt(tokenizer.nextToken())-1;
            graph[x][y] = true; // x 기준 y번 컴퓨터랑 연결되어 있다.
            graph[y][x] = true;
        }
        dfs(0);
        System.out.println(answer - 1);
        br.close();
    }

}
