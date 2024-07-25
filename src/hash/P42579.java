package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class P42579 {
    public int[] solution(String[] genres, int[] plays) {

        HashMap<String, ArrayList<int[]>> genreMap = new HashMap<>(); // key : 장르,  value: 재생횟수
        HashMap<String, Integer> playMap = new HashMap<>(); // key : 장르 , value : (고유번호, 재생횟수)

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            if (!genreMap.containsKey(genre)) {
                genreMap.put(genre, new ArrayList<>()); // 초기화 -> nullPointException 방지
                playMap.put(genre, 0);
            }
            genreMap.get(genre).add(new int[]{i, play});
            playMap.put(genre, playMap.get(genre) + play);
        }

        ArrayList<Integer> answer = new ArrayList<>();

        // 재생횟수 많은 순으로 내림차순 정렬
        Stream<Map.Entry<String, Integer>> sortedGenre = playMap.entrySet()
                .stream()
                .sorted(((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue())));

        // 장르 내 노래 정렬해 최대 2곡 선택
        sortedGenre.forEach(entry -> {
            Stream<int[]> sortedSongs = genreMap.get(entry.getKey()).stream()
                    .sorted((o1, o2) -> Integer.compare(o2[1], o1[1]))
                    .limit(2);
            sortedSongs.forEach(song -> answer.add(song[0]));
        });

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
