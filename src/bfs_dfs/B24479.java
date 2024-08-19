package bfs_dfs;

import java.util.*;
import java.io.*;

class B24479 {
    final static int MAX = 100000 + 10;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N, M, R;
    static int[] answer;
    static int order; // 방문여부 관리

    public static void dfs(int idx) {
        visited[idx] = true;
        answer[idx] = order;
        order++;

        for(int i = 0; i < graph[idx].size(); i++)
            if (!visited[graph[idx].get(i)])
                dfs(graph[idx].get(i));
    }

    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // graph에 연결 정보 채우기
        graph = new ArrayList[MAX];
        for(int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>(); // 각 정점에 연결된 정점 저장
        visited = new boolean[MAX];
        answer = new int[MAX];
        order = 1;

        for(int i = 0; i < M; i++){ // 간선정보 입력
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[y].add(x); // x 번째 리스트에서 y를 더하기
            graph[x].add(y); // y 번째 리스트에서 x를 더하기
        }

        //  오름차순 정렬
        for(int i = 1; i <= N; i++)
            Collections.sort(graph[i]);

        // dfs(재귀함수 호출)
        dfs(R); // 시작 정점 기준으로 탐

        // 출력
        for(int i = 1; i <=N; i++){
            System.out.println(answer[i]);
        }

    }
}







