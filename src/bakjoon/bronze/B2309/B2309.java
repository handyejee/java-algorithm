package bakjoon.bronze.B2309;

import java.util.Arrays;
import java.util.Scanner;

public class B2309 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] heights = new int[9];
    int sum = 0;

    for (int i = 0; i < 9; i++) {
      heights[i] = sc.nextInt();
      sum += heights[i];
    }

    Arrays.sort(heights);

    int idx1 = -1, idx2 = -1;
    for (int i = 0; i < 9; i++) {
      for (int j = i + 1; j < 9; j++) {
        if (sum - heights[i] - heights[j] == 100) {
          idx1 = i;
          idx2 = j;
          break;
        }
      }
    }

    for (int i = 0; i < heights.length; i++) {
      if (i == idx1 || i == idx2) {
        continue;
      }
      System.out.println(heights[i]);
    }
    sc.close();
  }
}
