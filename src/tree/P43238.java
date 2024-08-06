package tree;

import java.util.Arrays;

public class P43238 {

    public long solution(int n, int[] times) {
        Arrays.sort(times);  // 시간을 정렬하여 최적화

        long low = 1;
        long high = (long) times[times.length - 1] * n;  // 최대 시간 설정
        long answer = high;

        while (low <= high) {
            long mid = (low + high) / 2;
            long totalPeople = 0;

            // 주어진 중간 시간 내에 처리할 수 있는 사람 수 계산
            for (int time : times) {
                totalPeople += mid / time;
            }

            if (totalPeople >= n) {
                // n명 이상의 사람을 처리할 수 있다면, 더 짧은 시간으로 시도
                answer = mid;
                high = mid - 1;
            } else {
                // 처리할 수 있는 사람 수가 부족하면 시간을 늘림
                low = mid + 1;
            }
        }

        return answer;
    }

}

