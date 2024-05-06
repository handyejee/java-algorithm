import java.util.*;
public class B10828 {
    public static int[] arr;
    public static int size = 0;

    //push X: 정수 X를 스택에 넣는 연산이다.
    public static void push(int num){
        arr[size] = num;
        size++;
        System.out.println(arr[size]);
        System.out.println("size" + size);

    }

    // pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public static int pop(){
        if(size == 0) {
            return -1;
        }
        else {
            int remain = arr[size-1];
            arr[size - 1] = 0;
            size--;
            return remain;
        }
    }

    // top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public static int top() {
        if(size == 0){
            return -1;
        }
        else {
            return arr[size - 1];
        }
    }

    // empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
    public static int empty(){
        if (size == 0){
            return 1;

        } else {
            return 0;
        }
    }

    // size: 스택에 들어있는 정수의 개수를 출력한다.
    public static int size(){
        return size;
    }

    public static void main(String args[]) {
        // 입력 사용하기 위한 스캐너 선언
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        // 명령의 수
        int n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            String str = sc.next(); // 명령어 받아오기 위한 입력

            switch (str){
                case "push":
                    push(sc.nextInt());
                    break;

                case "pop":
                    sb.append(pop()).append('\n');
                    break;

                case "top":
                    sb.append(top()).append('\n');
                    break;

                case "size":
                    sb.append(size()).append('\n');
                    break;

                case "empty":
                    sb.append(empty()).append('\n');
                    break;
            }

        }
        System.out.println(sb);
    }
}