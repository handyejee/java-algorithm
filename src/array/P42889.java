package array;

import java.util.*;

// 프로그래머스 42889번 문제
class P42889 {
    public int[] solution(int N, int[] stages) {
        // 스테이지 별 도전자 수
        int[] challenger = new int[N + 2]; // 도전자 수 배열

        for (int i = 0; i < stages.length; i++) {
            challenger[stages[i]] += 1; // index를 맞춰서 담기
        }

        HashMap<Integer, Double> failArr = new HashMap<>(); // 실패율 값 담기 위해 double
        double total = stages.length;

        for (int i = 1; i <= N; i++) {
            if (challenger[i] == 0) {
                failArr.put(i, (double) 0);
            } else {
                failArr.put(i, challenger[i] / total); // 실패율 공식
                total -= challenger[i];
            }
        }

        // 스테이지 번호를 리스트로 변환
        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(failArr.entrySet());

        // 리스트를 실패율을 기준으로 정렬
        entryList.sort((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()));

        // 정렬된 리스트를 스테이지 번호 배열로 변환
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = entryList.get(i).getKey();
        }

        return result;
    }

    // 테스트 코드
    public static void main(String[] args) {
        P42889 solution = new P42889();
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] result = solution.solution(N, stages);
        System.out.println(Arrays.toString(result)); // [3, 4, 2, 1, 5] 예상 출력
    }

}

