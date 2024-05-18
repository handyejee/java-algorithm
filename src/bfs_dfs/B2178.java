package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2178 {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;

    // 상, 하, 좌, 우 이동 방향
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 미로 크기 입력받기
        N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine();

        // 미로 및 방문 배열 초기화
        maze = new int[N][M];
        visited = new boolean[N][M];

        // 미로 입력받기
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        // BFS 시작 (0, 0)에서
        int result = bfs(0, 0);
        System.out.println(result);
        scanner.close();
    }

    static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {startX, startY, 1});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            // 도착 지점에 도달한 경우
            if (x == N - 1 && y == M - 1) {
                return distance;
            }

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && maze[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny, distance + 1});
                }
            }
        }

        return -1; // 도달할 수 없는 경우
    }
}