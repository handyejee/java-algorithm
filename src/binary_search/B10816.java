package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B10816 {
    public static void main(String[] args) throws IOException {
        // HashMap으로 풀기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine()); // n 입력받기

        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 공백 기준으로 자르기
        for (int i = 0; i < N; i++) {
            int keyOfN = Integer.parseInt(st.nextToken());
            // map에서 key에 해당하는 값 가져온다
            // key가 map에 존재하지 않으면 기본값 0, key가 존재하면 해당 값 + 1
            map.put(keyOfN, map.getOrDefault(keyOfN, 0) + 1);
        }
        System.out.println(map);


        int M = Integer.parseInt(br.readLine()); // m 입력받기

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine()); // StringTokenizer 다시 선언

        for (int i = 0; i < M; i++) {
            int keyOfM = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(keyOfM, 0)).append(' ');
        }
        System.out.println(map);
        System.out.println(sb);
    }
}
