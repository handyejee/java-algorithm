package binary_search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B18870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //입력 읽기
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        // 좌표 정렬 및 고유 순위 매기기
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        Map<Integer, Integer> coordinateCompression = new HashMap<>();
        int rank = 0;
        for (int coord : sortedNums) {
            if (!coordinateCompression.containsKey(coord)) {
                coordinateCompression.put(coord, rank);
                rank++;
            }
        }

        // 3. 결과 출력
        StringBuilder result = new StringBuilder();
        for (int coord : nums) {
            result.append(coordinateCompression.get(coord)).append(" ");
        }
        System.out.println(result.toString().trim());
    }

}
