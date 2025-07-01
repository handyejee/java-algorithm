package bakjoon.silver.b1182;

import java.util.*;

public class B1182 {
    static int N, S;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N ; i++) {
            arr[i] = sc.nextInt();
        }

        backtrack(0 , 0, 0);

        System.out.println(count);
    }

    static void backtrack(int index, int currentSum, int selectedCount) {
        if (index == N) {
            if (currentSum == S && selectedCount > 0) {
                count++;
            }
            return;
        }

        backtrack(index + 1, currentSum, selectedCount);

        backtrack(index + 1, currentSum + arr[index], selectedCount + 1);
    }
}
