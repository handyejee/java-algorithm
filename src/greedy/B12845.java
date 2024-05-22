package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B12845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Integer[] lArr = new Integer[n]; // 카드의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            lArr[i] = Integer.parseInt(st.nextToken()); // 카드 레벨
        }
        Arrays.sort(lArr, Collections.reverseOrder()); // 레밸 배열 내림차순 정렬
//        System.out.println(Arrays.toString(arr));

        int max = lArr[0]; // 내림차순 정렬 했으니까 0번째 값은 항상 제일 큰 값
        int sum = 0;

        for (int i = 1; i < lArr.length; i++) {
            sum += (max + lArr[i]);
        }
        System.out.println(sum);
    }
}
