package programmers.LV2.p42842;

public class P42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int total = brown + yellow;

        for (int h = 0; h < total; h++) {
            if (total % h == 0) {
                int w = total / h;

                if (w >= h) {
                    if ((w - 2) * (h - 2) == yellow) {
                        answer[0] = w;
                        answer[1] = h;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
