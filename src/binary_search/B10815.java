package binary_search;

import java.util.*;
import java.io.*;

public class B10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 자연수 N
        int[] numArr = new int[N]; // N 담을 배열 선언
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numArr); // 오름차순 정렬

        int M = Integer.parseInt(br.readLine()); // 숫자 M
        StringBuilder sb = new StringBuilder(); // 결과 출력 위한 StringBuilder 선언

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int findNum = Integer.parseInt(st.nextToken()); // M의 크기만큼 찾을 숫자 입력받음
            boolean found = false;

            int low = 0;
            int high = numArr.length -1;

            while (low <= high){
                int mid = (low + high) / 2;

                if (findNum < numArr[mid]) {
                    high = mid - 1;

                }else if(findNum > numArr[mid]){
                    low = mid + 1;

                } else {
                    found = true;
                    break;
                }
            }
            if(found) {
                sb.append(1).append("\n");
            }
            else {
                sb.append(0).append("\n");
            }

        }
        System.out.println(sb);
    }
}
