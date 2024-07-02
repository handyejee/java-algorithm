package array;

// 행렬의 곱 구하는 문제
public class P12949 {
    public int[][]solution(int[][] arr1, int[][] arr2){
        // 행 열 값 나누기
        int row1 = arr1.length;
        int col1 = arr1[0].length;
        int col2 = arr2[0].length;

        // 배열 크기 선언
        int[][] answer = new int[row1][col2];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) { // k 가 배열 안에 방문
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
