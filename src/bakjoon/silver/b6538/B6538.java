package bakjoon.silver.b6538;

import java.util.Scanner;

public class B6538 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String result = encode(line);
            System.out.println(result);
        }
    }

    public static String encode(String input) {
        if (input.isEmpty()) { // 빈줄, 빈문자열 입력의 경우 빈문자열 반환
            return "";
        }

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < input.length()) { // 입력값의 크기만큼 반복
            char currentChar = input.charAt(i);
            int count = 1;

            // 몇개인지 먼저 계산
            while (i + count < input.length() && input.charAt(i + count) == currentChar) { // 현재 인덱스의 값이 이전 값과 동일한 경우 count++
                count++;
            }

            if (count >= 2) { // 반복되는 문자인 경우
                int remaining = count;

                while (remaining >= 2) {
                    int encodeCount = Math.min(remaining, 9); // 최대가 9라서 9랑 비교해서 더 작은 숫자로
                    result.append(encodeCount).append(currentChar);
                    remaining -= encodeCount;
                }

                if (remaining == 1) { // 남은 문자가 하나라면 '1'인코딩 확인
                    result.append("1");
                    if (currentChar == '1') {
                        result.append("11");
                    } else {
                        result.append(currentChar);
                    }
                    result.append("1");
                }
                i += count;

            } else { // 반복되지 않는 문자의 경우
                StringBuilder nonRepeating = new StringBuilder();

                while (i < input.length()) {
                    currentChar = input.charAt(i);

                    if (i + 1 < input.length() && input.charAt(i + 1) == currentChar) { // 연속문자를 발견한 경우 break
                        break;
                    }

                    if (currentChar == '1') {
                        nonRepeating.append("11");
                    } else {
                        nonRepeating.append(currentChar);
                    }
                    i++;
                }

                if (nonRepeating.length() > 0) {
                    result.append("1").append(nonRepeating).append("1");
                }
            }
        }

        return result.toString(); // 반환 타입 String 으로 변환
    }
}
