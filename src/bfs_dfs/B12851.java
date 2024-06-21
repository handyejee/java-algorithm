package bfs_dfs;

import java.util.*;
import java.io.*;

public class B12851 {
    // 필요한 값
    static final int MAX = 100001; // 가능한 위치의 최대값
    static int[] distance = new int[MAX]; // 각 위치까지 최단거리
    static int[] count = new int[MAX]; // 각 위치까지 도달하는 최단경로의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int K = Integer.parseInt(st.nextToken()); // 동생 위치

        // N이 K 보다 크거나 같은 경우 처리
        if (N >= K) {
            System.out.println((N - K));
            System.out.println(1);
            return;
        }

        bfs(N, K);

        System.out.println(distance[K]); // 목표까지 최단거리
        System.out.println(count[K]); // 목표까지 최단경로
    }

    private static void bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start); // 수빈이 위치 큐에 넣기

        while (!queue.isEmpty()) {
            int current = queue.poll();

            int[] nextPositions = {current - 1, current + 1, current * 2};

            for(int next : nextPositions){
                if(next >= 0 && next < MAX){
                    if(distance[next] == 0) { // 처음 방문하는 경우
                        distance[next] = distance[current] + 1;
                        count[next] = count[current];
                        queue.add(next);

                    } else if (distance[next] == distance[current] + 1) { // 이미 최단 거리로 방문한 경우
                        count[next] += count[current];
                    }

                }
            }
        }
    }
}
