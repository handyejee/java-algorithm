package hash;

import java.util.ArrayList;
import java.util.HashMap;

public class P42888 {

    public String[] solution(String[] record) {

        HashMap<String, String> message = new HashMap<>(); // 	{Enter=님이 들어왔습니다., Leave=님이 나갔습니다.}
        message.put("Enter", "님이 들어왔습니다.");
        message.put("Leave", "님이 나갔습니다.");


        HashMap<String, String> id = new HashMap<>();

        for (String r : record) { // {uid1234=Prodo, uid4567=Ryan}
            String[] cmd = r.split(" ");
            if(cmd.length == 3){ // Enter, Leave는 크기가 3이고, leave는 크기가 2다
                id.put(cmd[1], cmd[2]); // id, 닉네임 넣기
            }
        }

        ArrayList<String> answer = new ArrayList<>(); //답 저장할 리스트
        for (String r : record){
            String[] cmd = r.split(" ");
            if(message.containsKey(cmd[0])){ // message 맵에 Enter, Leave가 있으면
                answer.add(id.get(cmd[1]) + message.get(cmd[0]));
            }
        }

        return answer.toArray(new String[0]); // List를 array로

    }
}
