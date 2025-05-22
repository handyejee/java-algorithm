package bakjoon.bronze.B16283;

import java.util.Scanner;

public class B16283 {

  public static void main(String[] args) {

    int sheep = 0;
    int goat = 0;
    int count = 0;

    // a, b, n, w 입력받기
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int n = sc.nextInt();
    int w = sc.nextInt();

    // n의 크기만큼 반복
    for (int i = 1; i <= n - 1; i++) {
      int x = i;
      int y = n - i;

      if ((a * x) + (b * y) == w) {
        count++;
        sheep = x;
        goat = y;
      }
    }

    // count가 1이면 양과 염소 반환, 그외 -1 반환
    if (count == 1) {
      System.out.println(sheep + " " + goat);
    } else {
      System.out.println(-1);
    }
  }
}
