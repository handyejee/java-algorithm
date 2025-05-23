package bakjoon.bronze.B2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2309 {

  public static void main(String[] args) throws IOException {

    // 크기가 9인 배열 선언
    int[] arr = new int[9];
    int total = 0;

    // 9개의 숫자를 입력받는다
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int i = 0; i < 9; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      total += arr[i];
    }

    // 오름차순으로 출력하기 위해 정렬
    Arrays.sort(arr);

    // 9개 숫자 중 7개를 뽑아 합이 100인지 확인
    for (int i = 0; i < 9; i++) {
      for (int j = i + 1; j < 9; j++) {

        int now = total - arr[i] - arr[j];
        if (now == 100) {
          for (int k = 0; k < 9; k++) {
            if (k != i && k != j) {
              System.out.println(arr[k]);
            }
          }
          return;
        }
      }
    }
  }
}
