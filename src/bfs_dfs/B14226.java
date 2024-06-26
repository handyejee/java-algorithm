package bfs_dfs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B14226 {
    // 상태를 나타내는 클래스
    static class State {
        int screen;
        int clipboard;
        int time;

        State(int screen, int clipboard, int time) {
            this.screen = screen;
            this.clipboard = clipboard;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();  // 목표 이모티콘 개수 입력 받음

        // 방문 여부 체크: visited[screen][clipboard]
        boolean[][] visited = new boolean[2001][2001];

        // BFS 큐 초기화
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(1, 0, 0));  // 초기 상태: 화면에 이모티콘 1개, 클립보드 0개, 시간 0
        visited[1][0] = true;  // 초기 상태 방문 처리

        while (!queue.isEmpty()) {
            State current = queue.poll();  // 큐에서 현재 상태를 꺼냄

            // 목표 상태에 도달한 경우
            if (current.screen == S) {
                System.out.println(current.time);  // 현재까지 걸린 시간을 출력하고 종료
                return;
            }

            // 1: 화면의 이모티콘을 모두 클립보드에 복사
            if (!visited[current.screen][current.screen]) {
                visited[current.screen][current.screen] = true;  // 방문 처리
                queue.add(new State(current.screen, current.screen, current.time + 1));
            }

            // 2: 클립보드의 이모티콘을 화면에 붙여넣기
            if (current.clipboard > 0 && current.screen + current.clipboard < 2001) {
                if (!visited[current.screen + current.clipboard][current.clipboard]) {
                    visited[current.screen + current.clipboard][current.clipboard] = true;  // 방문 처리
                    queue.add(new State(current.screen + current.clipboard, current.clipboard, current.time + 1));
                }
            }

            // 3: 화면의 이모티콘 중 하나를 삭제
            if (current.screen > 1) {
                if (!visited[current.screen - 1][current.clipboard]) {
                    visited[current.screen - 1][current.clipboard] = true;  // 방문 처리
                    queue.add(new State(current.screen - 1, current.clipboard, current.time + 1));
                }
            }
        }
    }
}

