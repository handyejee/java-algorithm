import java.util.*;
import java.util.stream.IntStream;

public class B1158 {
    public static ArrayList permutation(int N , int K){
        Queue queue = new LinkedList();

        // 순열 값 출력해주기 위한 arrayList 선언
        ArrayList<Integer> result = new ArrayList<>();

        // 데이터 담아주기
        IntStream.range(1, N + 1).forEach(x -> queue.add(x));
        int cnt = 0;

        while (!queue.isEmpty()){
            // queue에서 값 빼서 저장
            int data = (int)queue.remove();
            cnt += 1;

            if (cnt % K == 0){
                result.add(data);
            } else {
                queue.add(data);
            }
        }
        return result;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int N, K;
        N = sc.nextInt();
        K = sc.nextInt();

        ArrayList<Integer> result = permutation(N, K);
 //
//        System.out.println(result.size() -1);

        StringBuilder sb = new StringBuilder();

//        sb.append("<");
//        for(int element : result){
//            if ((element != result.get(result.size() -1))){
//                sb.append(element).append(", ");
//            }
//        }
//        sb.append(">");

        System.out.print(result.toString().replace("[", "<").replace("]", ">"));

    }
}