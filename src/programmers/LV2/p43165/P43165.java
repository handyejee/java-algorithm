package programmers.LV2.p43165;

public class P43165 {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0,0);

        return answer;
    }

    public void dfs(int[] numbers, int target, int index, int currentSum) {
        // 종료 조건
        if (index == numbers.length) {
            if (currentSum == target) {
                answer++;
            }
            return;
        }

        // 연산
        dfs(numbers, target, index + 1, currentSum + numbers[index]);
        dfs(numbers, target, index + 1, currentSum - numbers[index]);
    }

}
