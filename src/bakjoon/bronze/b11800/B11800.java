package bakjoon.bronze.b11800;

import java.util.Scanner;

public class B11800 {
    public static void main(String[] args) {
        String[] index = new String[]{"Yakk", "Doh","Seh", "Ghar", "Bang" ,"Sheesh"};
        String[] evenNum = new String[]{"Habb Yakk", "Dobara", "Dousa", "Dorgy", "Dabash", "Dosh"};

        // 입력
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        // 연산
        for (int i = 1; i <= T ; i++) {
            int diceA = sc.nextInt();
            int diceB = sc.nextInt();

            String result;

            if(diceA == diceB) {
                result = evenNum[diceA - 1];
            } else if ((diceA == 6 && diceB == 5) || (diceA == 5 && diceB == 6)) {
                result = "Sheesh Beesh";
            } else {
                int max = Math.max(diceA, diceB);
                int min = Math.min(diceA, diceB);
                result = index[max-1] + " " + index[min-1];
            }
            // 출력
            System.out.println("Case " + i + ": " + result);
        }
    }
}
