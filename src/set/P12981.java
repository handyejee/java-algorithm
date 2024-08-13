package set;

import java.util.*;

class P12981 {
    public int[] solution(int n, String[] words) {

        HashSet<String> setWords = new HashSet<>(); // words의 단어 담아줄 집합
        char prevWord = words[0].charAt(0); // 이전단어 마지막 글자

        for(int i = 0; i < words.length; i++) { // words 배열의 크기만큼 반복

            // 중복으로 들어오거나, 이전단어 마지막 글자랑 첫글자 일치 하지 않는 경우
            if(setWords.contains(words[i]) || words[0].charAt(0) != prevWord){
                // 어떤 사람이 몇번째에 일치하지 않는지 구하기(모듈러 공식)
                return new int[] {(i % n) + 1, (i /n) + 1};
            }

            // 단어집합에 단어 넣어준다
            setWords.add(words[i]);

            // 이전 단어를 현재 단어의 끝 글자로 새로 바꿔준다
            prevWord = words[i].charAt(words[i].length() - 1);
        }

        // 중복, 일치하는 경우가 없는 경우 반환
        return new int[] {0 , 0};
    }
}
