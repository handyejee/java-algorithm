package bakjoon.gold.b14719;

import java.io.*;
import java.util.*;

public class B14719 {
    public static void main(String[] args) {
        // 빗물 H, W 담기
       Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();

        // 건물 높이 height 배열에 담기
        int[] heights = new int[W];
        for (int i = 0; i < W; i++) {
            heights[i] = sc.nextInt();
        }

        // 왼쪽 최대 높이
        int[] leftMax = new int[W];
        leftMax[0] = heights[0]; // 비교할 값이 없으니까 자기 자신이 최대값
        for (int i = 1; i < W; i++) { // 0번을 처리했으니까 1번부터 시작
            leftMax[i] = Math.max(leftMax[i-1], heights[i]);
        }

        // 오른쪽 최대높이
        int[] rightMax = new int[W];
        rightMax[W - 1] = heights[W - 1];
        for (int i = W -2 ; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
        }

        // 고이는 빗물 계산
        int total = 0;
        for (int i = 1; i < W - 1; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            if (waterLevel > heights[i]) {
                total += waterLevel - heights[i];
            }
        }
        // 최대값 반환
        System.out.println(total);

    }
}
