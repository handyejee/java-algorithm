package stack;

import java.util.Arrays;
import java.util.Stack;

public class P64601 {
    public int solution(int[][] board, int[] moves) {

        // 배열을 스택으로 저장하기
        Stack<Integer>[] stacks = new Stack[board.length]; // board 의 길이만큼 stack 만들기
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

    public static void main(String[] args) {
        P64601 sol = new P64601();

        // 예제 테스트 케이스
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        int result = sol.solution(board, moves);
        System.out.println("Result: " + result); // 예상 출력: 4

    }
}
