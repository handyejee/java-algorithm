package programmers.LV1.p340199;

import java.util.Arrays;

public class P340199 {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        while (true) {
            Arrays.sort(wallet);
            Arrays.sort(bill);

            if (bill[0] <= wallet[0] && bill[1] <= wallet[1]) {
                break;
            }

            bill[1] = bill[1] / 2; // 더 긴쪽을 반으로 나눈다
            answer++;
        }

        return answer;
    }
}
