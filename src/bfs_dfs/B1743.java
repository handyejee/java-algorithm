package bfs_dfs;

import java.util.*;
import java.io.*;

public class B1743 {
    // 필요한 변수 선언 
    static int N, M, foodSize; // 음식물 크기
    static boolean[][] graph;
    static boolean[][] visited;

    // 상하좌우 이동방향
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {-0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException{
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        foodSize = Integer.parseInt(st.nextToken()); // 음식물 사이즈

        graph = new boolean[N + 1][M + 1]; // 음식물 배열 -> 1부터 계산해주려고 + 1 해줌
        visited = new boolean[N + 1][M + 1]; // 방문배열

        for (int i = 0; i < foodSize; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true; // 그래프에 좌표 값 입력

        }

        // 가장 큰 음식물 찾기
        int maxFood = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(graph[i][j] && !visited[i][j]){ // 그래프 배열에 값이 있고 방문하지 않은 경우
                    int food = bfs(i, j); // bfs 탐색해서 음식물 찾기
                    maxFood = Math.max(maxFood, food); // 탐색한 값중 최대값 구하기
                }
            }
        }
        System.out.println(maxFood);
    }

    static int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int count = 0;

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            count++; // 방문 노드수 증가

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i]; // 인접 숫자
                int ny = current[1] + dy[i];

                // 세로 길이 N(1 ≤ N ≤ 100)과 가로 길이 M(1 ≤ M ≤ 100) 그리고 음식물 쓰레기의 개수 K(1 ≤ K ≤ N×M) 조건
                // visited (nx, ny) 배열 방문하지 않은 경우
                // graph (nx, ny) 배열에 값이 있는 경우
                if(nx >= 1 && ny >= 1 && nx <= N && ny <= M){
                    if(!visited[nx][ny] && graph[nx][ny]){
                        queue.add(new int[]{nx, ny}); // 인접 노드를 큐에 추가
                        visited[nx][ny] = true; // 방문했다고 표시
                    }
                }
            }
        }
        return count;
    }
}
