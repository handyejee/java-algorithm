package binary_search;

import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class B3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 한줄에 두개씩 입력받기 위해 필요

        int N = Integer.parseInt(st.nextToken()); // 입국 심사대 수
        long M = Long.parseLong(st.nextToken()); // 입국 심사 받을 사람 수

        long max = 0;

        long[] friends = new long[N]; // 입국 심사 한 사람당 걸리는 시간

        //한명당 입국심사 걸리는 시간 입력받기
        for (int i = 0; i < N; i++) {
            friends[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, friends[i]); // 배열에서 입력받은 값 중 최대값 구하기->배열에서 제일 심사에 길게 걸리는 사람 구하기
        }
        Arrays.sort(friends); // 이진탐색은 정렬된 배열만 가능하다

//        System.out.println(Arrays.toString(friends));
//        System.out.println(max);

        // 이진 탐색 부분
        long start = 1;
        long end = max * M; // 사람 수를 곱해야 총 걸리는 시간이 나오니까

        while (start <= end){
            long mid = (start + end) / 2; // 총 걸리는 시간의 중간 값 구하기
            long count;
            long sum = 0;

            for(int j = 0; j < N;  j++){
                count = mid / friends[j];// 검색대 당 입국심사 시간 구하기
//                System.out.println(count);

                if (sum >= M){
                    break;
                }
                sum += count;
            }

            if (sum < M){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start);
    }
}
