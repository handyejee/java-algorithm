package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class B10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine(); // 최초 입력받은 숫자
        String[] n = input.split(""); // 숫자 하나씩 잘라 String 배열에 넣음

        Integer[] numArr = new Integer[n.length]; // Integer 배열 선언
        int sum = 0;

        for (int i = 0; i < n.length; i++) {
            numArr[i] = Integer.parseInt(n[i]);
            sum += numArr[i];
        }
        Arrays.sort(numArr, Collections.reverseOrder());

        if(numArr[numArr.length -1] == 0 && sum % 3 == 0){
           for (int i = 0; i < numArr.length; i++) {
               System.out.print(numArr[i]);
           }
        }else {
           System.out.println(-1);
        }
    }
}
