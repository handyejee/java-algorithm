package bfs_dfs;

import java.util.*;
import java.io.*;
public class B1012 {
    final static int MAX = 50 + 10;
    static boolean map[][];
    static boolean visited[][];
    static int T, N, M, K;

    // 상하좌우 방문하기
    // 두개의 인덱스
    static int[] dirY = {-1, 1, 0, 0};
    static int[] dirX = {0, 0, -1, 1};

    static void dfs(int y, int x){
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) { // 4 -> direction의 개수
            int newY = y + dirY[i]; // 내가 방문할 상하좌우의 값을 newY newX가 가지고 있을 것이다.
            int newX = x + dirX[i];

            // 상하좌우 지점중에 배추가 존재한다면, 방문한적이 없다면 dfs 호출
            if(map[newY][newX] && visited[newY][newX] == false){
                dfs(newY, newX);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

        while (T --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 배추 심은 밭 가로
            N = Integer.parseInt(st.nextToken()); // 배추 심은 밭 세로
            K = Integer.parseInt(st.nextToken()); // 배추 심어진 위치 개수

            map = new boolean[MAX][MAX];
            visited = new boolean[MAX][MAX];

            // 1. map 정보 반영
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // 배추의 x 위치 좌표
                int y = Integer.parseInt(st.nextToken()); // 배추의 y 위치 좌표
                map[y + 1][x + 1] = true; // map에 반영해줌
            }

            // 2. dfs 수행 ( (1, 1) ~ (N, N) 까지 배추가 존재하는 모든 위치 방문)
            int answer = 0;
            for (int i = 1; i <= N; i++) { // 1,1 부터 시작하지 않으면 range를 확인해줘야 한다.
                for (int j = 1; j <= N ; j++) {
                    if(map[i][j] && visited[i][j] == false) {// 배추가 존재할 경우, visited 배열에 값이 false 일 경우 수행하는 조건
                        answer++; // 한번 호출될때마다 ++
                        dfs(i, j); // dfs 수행
                    }
                }
            }

            // 3. 출력
            bw.write(String.valueOf(answer));
            bw.newLine();
        }
        bw.close();
        br.close();
    }
}
