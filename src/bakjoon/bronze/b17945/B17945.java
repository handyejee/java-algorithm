package bakjoon.bronze.b17945;

import java.util.*;

public class B17945 {
    public static void main(String[] args) {
        // 계수 A, B를 입력받는다
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        // 구한 근을 넣어줄 리스트
        List<Integer> roots = new ArrayList<>();

        for (int x = -1000; x < 1000; x++) {
            if (x*x + 2*A*x + B == 0) {
                if (!roots.contains(x)) {
                    roots.add(x);
                }
            }
        }

        // 오름차순 정렬
        Collections.sort(roots);

        // 출력
        for (int i = 0; i < roots.size(); i++) {
            System.out.print(roots.get(i));
            if (i < roots.size() - 1) { // 마지막 원소가 아닌 경우
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
