package bfs_dfs;

public class P43162 {
    public int solution(int n, int[][] computers) {
        int answer = 0; // 네트워크 수
        boolean[] visited = new boolean[computers.length]; // 방문배열(컴퓨터 개수만큼)

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) { // 컴퓨터 방문하지 않은 경우
                answer++; // 새로운 네트워크 추가
                dfs(i, visited, computers); // 해당 컴퓨터 시점으로 탐색
            }
        }

        return answer;
    }

    public void dfs(int node, boolean[] visited, int[][] computers) { //
        visited[node] = true;

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[node][i] == 1) { // 연결된 모든 컴퓨터 확인해서 방문되지 않은 컴퓨터 있으면
                dfs(i, visited, computers); // dfs 호출해 탐색
            }
        }
    }
}

