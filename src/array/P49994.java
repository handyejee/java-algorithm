package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class P49994 {

    // 좌표평면을 벗어나는지 체크하는 메소드
    private static boolean isValidMove(int nx, int ny) {
        return 0 <= nx && nx < 11 && 0 <= ny && ny < 11;
    }

    //  다음 좌표 결정을 위한 HashMap 생성
    private static final HashMap<Character, int[]> location = new HashMap<>();

    private static void initLocation() {
        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0, -1});
        location.put('L', new int[]{-1, 0});
        location.put('R', new int[]{1, 0});
    }

    public int solution(String dirs) {
        initLocation();

        int x = 5, y = 5;
        HashSet<String> answer = new HashSet<>();

        //  주어진 명령어로 움직이면서 좌표 저장
        for (int i = 0; i < dirs.length(); i++) {
            int[] offset = location.get(dirs.charAt(i));

            System.out.println("offset :" + Arrays.toString(offset));

            int nx = x + offset[0];
            int ny = y + offset[1];
            if (!isValidMove(nx, ny))
                continue;

            answer.add(x + " " + y + " " + nx + " " + ny);
            answer.add(nx + " " + ny + " " + x + " " + y);

            x = nx;
            y = ny;
        }

        return answer.size() / 2;
    }

    public static void main(String[] args) {
        P49994 solution = new P49994();  // 인스턴스 생성

        // 테스트 케이스
        String dirs = "ULURRDLLU";
        int result = solution.solution(dirs);

        // 결과 출력
        System.out.println("Result: " + result);  // 예상 출력: 7

        // 추가 테스트 케이스
        String dirs2 = "LULLLLLLU";
        int result2 = solution.solution(dirs2);

        // 결과 출력
        System.out.println("Result: " + result2);  // 예상 출력: 다른 값 (테스트 필요)
    }

}
