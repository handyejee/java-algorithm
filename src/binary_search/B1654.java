package binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class B1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선 개수

        int[] arr = new int[K]; // 랜선들 담을 배열

        long max = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long min = 0;
        long mid = 0;

        while (min <= max) {
            mid = (max + min) / 2;
            long count = 0;

            for (int lan : arr) { // 총 몇개가 만들지는지 구하기
                count += (lan / mid);
            }

            if(count < N) {
                max = mid;
            }

            else {
                min = mid + 1;
            }
        }
        System.out.println(min);
    }
}

