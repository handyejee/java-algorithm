package programmers.LV1.P68644;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

// 프로그래머스 두 개 뽑아서 더하기 문제
class P68644 {
    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>(); // 숫자 더한 값 넣어주기 위한 set 컬렉션 선언

        for (int i = 0; i < numbers.length; i++){
            for (int j = i + 1; j < numbers.length; j++){
                set.add(numbers[i] + numbers[j]); // set에 더한 값을 바로 넣어줌
            }
        }

        // HashSet -> ArrayList
        ArrayList<Integer> list = new ArrayList<>(set);

        Collections.sort(list);

        // ArrayList -> Array
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}