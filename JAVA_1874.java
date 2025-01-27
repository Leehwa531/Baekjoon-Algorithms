import java.util.*;

public class JAVA_1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int current = 1; // 스택에 넣을 값
        boolean isPossible = true;

        // 목표 수열 입력
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int target = list[i];

            // 목표값까지 push
            while (current <= target) {
                stack.push(current++);
                sb.append("+\n");
            }

            // 스택의 top이 목표값과 같으면 pop
            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                // 수열을 만들 수 없는 경우
                isPossible = false;
                break;
            }
        }

        // 결과 출력
        if (isPossible) {
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }
        sc.close();
    }
}
