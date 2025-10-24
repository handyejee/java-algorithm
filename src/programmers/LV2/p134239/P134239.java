package programmers.LV2.p134239;

import java.util.*;

public class P134239 {
    public double[] solution(int k, int[][] ranges) {
        // 우박 수열 담을 리스트
        List<Integer> numberSequence = new ArrayList<>();
        numberSequence.add(k); // 최초 k의 값 넣어준다

        // 우박수열 계산
        while (k > 1) { //2.결과로 나온 수가 1보다 크다면 1번 작업을 반복합니다.
            //1-1. 입력된 수가 짝수라면 2로 나눕니다.
            if (k % 2 == 0) {
                k = k / 2;
            } else {  //1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
                k =  k * 3 + 1;
            }
            numberSequence.add(k);
        }
        System.out.println("우박수열: " + numberSequence);

        // 사다리꼴 계산
        int n = numberSequence.size() - 1;
        double[] answer = new double[ranges.length];

        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0]; // 구하고자 하는 범위의 크기를 저장
            int b = ranges[i][1];

            int start = a;
            int end = n + b;

            if (start > end) { // 시작점보다 끝점이 큰 경우
                answer[i] = -1.0;
                continue;
            }

            // 정적분
            double totalArea = 0.0; // range 별 사다리꼴 크기

            // 사다리꼴 면적 구하기(윗변 + 아랫면) * 높이 / 2
            for (int j = start; j < end ; j++) {
                double area = (numberSequence.get(j) + numberSequence.get(j + 1)) * 1.0 / 2.0;
                totalArea += area;
                System.out.println("totalArea" + totalArea);
            }
            answer[i] = totalArea; // 구한 범위 별 사다리꼴 크기를 ranges[i]에 넣어줌
        }

        return answer;
    }

    public static void main(String[] args) {
        P134239 solution = new P134239();

        // 테스트 케이스 1: k=5
        int k1 = 5;
        int[][] ranges1 = {{0,0}, {0,-1}, {2,-3}, {3,-3}};
        double[] result1 = solution.solution(k1, ranges1);
        System.out.println("k=5 결과: " + Arrays.toString(result1));
        System.out.println("예상 결과: [33.0, 31.5, 0.0, -1.0]");
        System.out.println();

        // 테스트 케이스 2: k=3
        int k2 = 3;
        int[][] ranges2 = {{0,0}, {1,-2}, {3,-3}};
        double[] result2 = solution.solution(k2, ranges2);
        System.out.println("k=3 결과: " + Arrays.toString(result2));
        System.out.println("예상 결과: [47.0, 36.0, 12.0]");
    }
}
