package binary_search;

import java.util.Scanner;

public class B2805 {
    public static void main(String[] args) {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 나무의 수
        int M = sc.nextInt(); // 필요한 나무 길이

        int trees[] = new int[N]; // 나무 담을 배열

        int start = 0;
        int end = 0;

        for (int i = 0; i < N; i++){ // 나무 갯수만큼 나무 길이 입력 받음
            trees[i] = sc.nextInt();

            if(end < trees[i]){ // max 값보다 인덱스 값이 크면 바꿔주기
                end = trees[i];
            }
        }

        // 이진탐색
        while (start < end) {
            int mid = (start + end) / 2; // 나무의 중간 값 구하기
            long sum = 0;

            for (int tree : trees){ // 나무들 배열 반복하면서
                if (tree - mid > 0) { // mid 값이 0보다 큰 경우에만
                    sum += (tree - mid); // 나무 위쪽 자른 부분 더하기
                }
            }

            if (sum < M){ // M 값이 총 합보다 작은 경우 중간값을 mid 값으로 바꾼다
                end = mid;
            } else { // max값이 필요한 나무길이보다 큰 경우
                start = mid + 1;
            }
        }
        System.out.println(start -1); // M = sum인 경우를 위해서 -1 해준다
    }
}
