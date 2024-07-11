package stack;

import java.util.Stack;

public class P64601 {
    public int solution(int[][] board, int[] moves) {

        // 스택 배열로 저장
        Stack<Integer>[] stacks = new Stack[board.length];
        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = new Stack<>();
        }

        // 배열 역순으로 스택에 인형 넣기
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0) {
                    stacks[j].push(board[i][j]);
                }
            }
        }

        // 인형을 담을 바구니
        Stack<Integer> bucket = new Stack<>();
        int answer = 0; // 사라진 인형 개수

        for (int move : moves) {
            if (!stacks[move - 1].isEmpty()) {
                int doll = stacks[move - 1].pop();
                if (!bucket.isEmpty() && bucket.peek() == doll) {
                    bucket.pop();
                    answer += 2;
                } else {
                    bucket.push(doll);
                }
            }
        }

        return answer;
    }
}
