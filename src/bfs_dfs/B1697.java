package bfs_dfs;

import java.util.*;

public class B1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.print(findFastest(N, K));
    }

    public static int findFastest(int N, int K) {
        int max = 100000;
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[max + 1];
        q.add(new int[]{N, 0});
        visited[N] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int position = current[0];
            int time = current[1];

            if (position == K) {
                return time;
            }

            int nextPosition = position - 1;
            if (nextPosition >= 0 && !visited[nextPosition]) {
                visited[nextPosition] = true;
                q.add(new int[]{nextPosition, time + 1});
            }

            nextPosition = position + 1;
            if (nextPosition <= max && !visited[nextPosition]) {
                visited[nextPosition] = true;
                q.add(new int[]{nextPosition, time + 1});
            }

            nextPosition = position * 2;
            if (nextPosition <= max && !visited[nextPosition]) {
                visited[nextPosition] = true;
                q.add(new int[]{nextPosition, time + 1});
            }
        }

        return -1;
    }
}
