package tree;

public class P12985 {
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        for(answer = 0; a != b; answer++){ // 참가자의 번호가 같아질때까지
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }

        return answer;
    }
}
