package bakjoon.silver.b1138;

import java.util.*;

public class B1138 {
    public static void main(String[] args) {
        
        // 입력
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] numArray = new int[N];
        for (int i = 0; i < N ; i++) {
            numArray[i] = sc.nextInt();
        }

        ArrayList<Integer> list = new ArrayList<>();

        // 연산
        for (int i = N; i >= 1; i--) {
            int count = numArray[i - 1];
            list.add(count, i); // count 위치에 i를 삽입
        }

        // 출력
        for (Integer num : list) {
            System.out.print(num + " ");
        }
    }
}
