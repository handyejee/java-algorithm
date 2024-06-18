package bfs_dfs;

import java.io.*;
import java.util.*;

public class B7576 {
    static int M, N;
    static int[][] box;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M]; // 입력받은 N, M 사이즈 만큼 배열 선언

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int days = bfs(queue);

        // Check if there are still unripe tomatoes
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(days);
    }

    static int bfs(Queue<int[]> queue) {
        int days = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                assert current != null;
                int x = current[0];
                int y = current[1];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < M && box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            days++;
        }

        return days;
    }
}
