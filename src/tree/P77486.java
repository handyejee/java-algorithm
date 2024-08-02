package tree;

import java.util.HashMap;

class P77486 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        HashMap<String, String> parentMap = new HashMap<>(); // key : 판매원, value : 추천인
        for (int i = 0; i < enroll.length; i++) {
            parentMap.put(enroll[i], referral[i]);
        }

        HashMap<String, Integer> total = new HashMap<>(); // 판매자 수익 담을 맵

        for(int i = 0; i < seller.length; i++) {
            String curName = seller[i];
            int money = amount[i] * 100; // 판매자가 판매한 총 금액 갯수 * 100원

            while (money > 0 && !curName.equals("-")) { // 추천인이 있고 판매 금액이 있는 경우
                total.put(curName, total.getOrDefault(curName, 0) + money - (money / 10)); // 판매자별 판매 금액
                curName = parentMap.get(curName);
                money /= 10; // 10% 추천인에게 줄 금액 제외하고 계산
            }
        }

        int[] answer = new int[enroll.length]; // enroll 순서대로 판매금액 구하기
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = total.getOrDefault(enroll[i], 0);
        }
        return answer;
    }
}
