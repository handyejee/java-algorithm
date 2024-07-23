package hash;

import java.util.HashMap;

// 프로그래머스 제출내역 문제
class P131127 {
    public int solution(String[] want, int[] number, String[] discount) {
        int count = 0;

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < want.length; i++){ // want, number 하나의 맵에 넣어줌
            map.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++){ // 전체 배열 크기에서 10개씩 확인할 최대의 값 지정
            HashMap<String, Integer> userDcnt = new HashMap<>(); // discount 넣어줄 배열

            for(int j = i; j < i + 10; j++){ // 10개 까지 확인해줌
                if(map.containsKey(discount[j])){ // map에 discount 배열 순회하는 값이 있으면
                    userDcnt.put(discount[j], userDcnt.getOrDefault(discount[j], 0) + 1); // discount 값, key, 갯수 세어서 value로 넣어줌
                }
            }

            if(userDcnt.equals(map)){
                count++;
            }
//            System.out.println(userDcnt);
        }

        return count;
    }

    public static void main(String[] args) {
        P131127 p131127 = new P131127();
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}; // 예시 데이터

        p131127.solution(want, number, discount);
    }
}
