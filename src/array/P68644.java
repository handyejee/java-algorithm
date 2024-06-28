package array;

import java.util.HashSet;

// 프로그래머스 두 개 뽑아서 더하기 문제
class P8644 {
    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>(); // 숫자 더한 값 넣어주기 위한 set 컬렉션 선언

        for (int i = 0; i < numbers.length; i++){
            for (int j = i + 1; j < numbers.length; j++){
                set.add(numbers[i] + numbers[j]); // set에 더한 값을 바로 넣어줌
            }
        }

        // 스트림으로 변환, 오름차순으로 변환, map 컬렉션 기본 int 타입으로 변경 , 스트림 값을 배열로 변경
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}