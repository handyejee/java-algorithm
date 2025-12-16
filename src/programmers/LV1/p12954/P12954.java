package programmers.LV1.p12954;

public class P12954 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        // 연산
        for (int i = 0; i < n; i++) {
            answer[i] = (long)x * (i + 1);
        }

        // 출력
        return answer;
    }
}
