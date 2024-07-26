package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class P92334 {
    public int[] solution(String[] id_list, String[] report, int k) {

        HashMap<String, HashSet<String>> rptUser = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();

        for(String r : report) { // 신고한 아이디, 신고당한 아이디 분리
            String[] s = r.split(" ");
            String userId = s[0];
            String reportedId = s[1];

            if (!rptUser.containsKey(reportedId)){ // 맵에 신고한 아이디
                rptUser.put(reportedId, new HashSet<>());
            }
            rptUser.get(reportedId).add(userId);
        }

        for(Map.Entry<String, HashSet<String>> entry : rptUser.entrySet()){
            if (entry.getValue().size() >= k){
                for(String uid : entry.getValue()){
                    count.put(uid, count.getOrDefault(uid, 0) + 1);
                }
            }
        }

        int[] answer = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++){
            answer[i] = count.getOrDefault(id_list[i], 0);
        }

        return answer;
    }
}
