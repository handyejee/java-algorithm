package hash;

import java.util.HashMap;

// 프로그래머스 완주하지 못한 선수 문제
class P42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        // 완주자 맵에 담기
        HashMap<String, Integer> map = new HashMap<>();
        for (String runner : completion) {
            map.put(runner, map.getOrDefault(runner, 0) + 1);
        }

        // 참여자를 순회
        for(String p : participant) {
            if(map.getOrDefault(map, 0) == 0) {
                return p;
            }
            map.put(p, map.get(p) - 1); // 맵에서 참여자 이름을 찾으면 -1 해준다
        }

        return answer;
    }
}
