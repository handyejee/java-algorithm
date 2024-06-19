package bfs_dfs;

import java.io.*;
import java.util.*;

public class B1303 {

    static char[][] team; // 문자 값을 받아올꺼라서 char 배열
    static boolean[][] visit;
    static int N, M;
    static int [] dx = {-1, 1, 0 ,0};
    static int [] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 전쟁터 가로크기
        M = Integer.parseInt(st.nextToken()); // 전쟁터 세로크기
        team = new char[M][N]; // 전쟁배열
        visit = new boolean[M][N]; // 방문확인 배열

        for (int i = 0; i < M; i++) { // 행(세로) 입력 받기
            String teamLine = br.readLine(); // 한 행씩 입력 받음
            for (int j = 0; j < N; j++) { // 열(가로) 입력받기
                team[i][j] = teamLine.charAt(j); // 각 행의 j번째 문자 잘라서 가지고 옴
            }
        }

        // 전투력 변수 초기화
        int white = 0;
        int blue = 0;

        for(int i = 0; i < M; i++) { // 가로
            for (int j = 0; j < N; j++) { // 세로
                if (!visit[i][j]) { // 방문하지 않은 경우에 bfs 시작
                    int count = bfs(i, j, team[i][j]);
                    if (team[i][j] == 'W'){ // 현재 위치
                        white += count * count; // 제곱한 수를 합해줌
                    } else {
                        blue += count * count; // B인 경우
                    }
                }
            }
        }
        System.out.println(white + " " + blue); // 결과 출력
    }

    static int bfs(int x, int y, char teamChar) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visit[x][y] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N && !visit[nx][ny] && team[nx][ny] == teamChar) {
                    queue.add(new int[]{nx, ny});
                    visit[nx][ny] = true;
                }
            }
        }

        return count;
    }
}

