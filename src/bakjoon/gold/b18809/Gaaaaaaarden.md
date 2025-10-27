#algorithm

https://www.acmicpc.net/problem/18809
### 문제 분석 요약
- BOJ 마을의 정원에서 초록색 배양액과 빨간색 배양액을 뿌려 꽃을 피우는 문제
- 배양액은 매 초마다 인접한 땅으로 퍼져나가고, 두 배양액이 동일한 시간에 만나는 지점에서 꽃이 피어난다
- 모든 배양액을 사용해야 하며, 피울 수 있는 꽃의 최대 개수를 구하는 문제

### 제약조건
- N(2 ≤ N ≤ 50)과 M(2 ≤ M ≤ 50)
- 초록색 배양액의 개수 G(1 ≤ G ≤ 5)와 빨간색 배양액의 개수 R(1 ≤ R ≤ 5)
- 배양액을 뿌릴 수 있는 땅의 수는 R+G개 이상이고 10개 이하
### 알고리즘 설계

문제의 핵심
- 조합 생성: 배양액을 뿌릴 수 있는 땅(값이 2인 칸) 중에서 G+R개를 선택하고, 그 중 G개는 초록색, R개는 빨간색으로 배정
- BFS 시뮬레이션: 각 조합에 대해 BFS로 배양액 확산을 시뮬레이션
- 꽃 개수 계산: 두 배양액이 동일한 시간에 만나는 지점의 개수를 계산

#### 변수
- `N, M`: 정원의 크기
- `G, R`: 초록색, 빨간색 배양액 개수
- `garden[][]`: 정원 정보 (0: 호수, 1: 배양액 불가, 2: 배양액 가능)
- `candidates`: 배양액을 뿌릴 수 있는 땅의 좌표 리스트
- `maxFlowers`: 최대 꽃 개수
#### 입력
- 첫 줄: N, M, G, R
- N개 줄: 각 행의 정원 정보`
#### 연산
- 배양액 가능한 땅 좌표 수집
- 모든 가능한 배양액 배치 조합 생성
- 각 조합에 대해 BFS로 확산 시뮬레이션
- 꽃이 피는 지점 개수 계산 및 최댓값 갱신
#### 출력
- 피울 수 있는 꽃의 최대 개수
### 시간 복잡도
- O(C(10, G+R) × C(G+R, G) × N × M)
- 최악의 경우 10^6 정도로 1초안에 연산 가능

### 코드
```java  
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, G, R;
    static int[][] garden;
    static List<int[]> candidates;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxFlowers = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        garden = new int[N][M];
        candidates = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                garden[i][j] = Integer.parseInt(st.nextToken());
                if (garden[i][j] == 2) {
                    candidates.add(new int[]{i, j});
                }
            }
        }
        
        // 배양액을 뿌릴 위치 선택 (G + R개)
        selectPositions(0, 0, new boolean[candidates.size()]);
        
        System.out.println(maxFlowers);
    }
    
    // 배양액을 뿌릴 위치를 선택하는 조합 생성
    static void selectPositions(int idx, int selected, boolean[] used) {
        if (selected == G + R) {
            // 선택된 위치들 중에서 초록색과 빨간색 배양액 배정
            List<Integer> selectedIndices = new ArrayList<>();
            for (int i = 0; i < candidates.size(); i++) {
                if (used[i]) {
                    selectedIndices.add(i);
                }
            }
            assignColors(0, 0, selectedIndices, new int[selectedIndices.size()]);
            return;
        }
        
        if (idx >= candidates.size()) return;
        
        // 현재 위치 선택
        used[idx] = true;
        selectPositions(idx + 1, selected + 1, used);
        
        // 현재 위치 선택하지 않음
        used[idx] = false;
        selectPositions(idx + 1, selected, used);
    }
    
    // 선택된 위치에 초록색(1)과 빨간색(2) 배양액 배정
    static void assignColors(int idx, int greenCount, List<Integer> positions, int[] colors) {
        if (idx == positions.size()) {
            if (greenCount == G) {
                simulate(positions, colors);
            }
            return;
        }
        
        // 초록색 배양액 배정
        if (greenCount < G) {
            colors[idx] = 1;
            assignColors(idx + 1, greenCount + 1, positions, colors);
        }
        
        // 빨간색 배양액 배정
        if (positions.size() - idx > G - greenCount) {
            colors[idx] = 2;
            assignColors(idx + 1, greenCount, positions, colors);
        }
    }
    
    // BFS로 배양액 확산 시뮬레이션
    static void simulate(List<Integer> positions, int[] colors) {
        int[][] state = new int[N][M]; // 0: 빈땅, 1: 초록, 2: 빨강, 3: 꽃
        int[][] time = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();
        
        // 초기 배양액 위치 설정
        for (int i = 0; i < positions.size(); i++) {
            int[] pos = candidates.get(positions.get(i));
            state[pos[0]][pos[1]] = colors[i];
            queue.offer(new int[]{pos[0], pos[1], colors[i], 0});
        }
        
        int flowers = 0;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1], color = curr[2], t = curr[3];
            
            // 이미 꽃이 핀 곳이면 더 이상 확산하지 않음
            if (state[x][y] == 3) continue;
            
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (garden[nx][ny] == 0 || garden[nx][ny] == 1) continue;
                if (state[nx][ny] == 3) continue; // 이미 꽃이 핀 곳
                
                if (state[nx][ny] == 0) {
                    // 빈 땅인 경우
                    state[nx][ny] = color;
                    time[nx][ny] = t + 1;
                    queue.offer(new int[]{nx, ny, color, t + 1});
                } else if (state[nx][ny] != color && time[nx][ny] == t + 1) {
                    // 다른 색 배양액이 같은 시간에 도달한 경우
                    state[nx][ny] = 3; // 꽃이 핌
                    flowers++;
                }
            }
        }
        
        maxFlowers = Math.max(maxFlowers, flowers);
    }
}
```

### 알게된점
- dfs와 시뮬레이션이 같이 있어서 한번에 풀기가 어려웠다.
- 조합 + BFS + 시뮬레이션이 함께 있는데 한번에 같이 풀려고 하지 말고 나눠서 풀어야 헷갈리지 않음