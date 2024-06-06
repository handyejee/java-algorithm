package stack;

class PStock {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int min = prices[i]; // price 배열 인덱스 값을 최소로 설정

            for(int j = i + 1; j < prices.length; j++){
                answer[i]++; // return 값이 배열이기 때문에 answer배열 인덱스 값을 ++ 해준다

                if (min > prices[j]){ // min 값 보다 작아지는 값이 생기는 경우가 주식이 떨어진 기간
                    break; // 주식이 떨어지는 경우에 반복 하지 않음
                }
            }
        }
        return answer;
    }
}
