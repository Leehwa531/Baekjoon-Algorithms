import java.util.Scanner;

public class JAVA_2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int start = 1;  // 시작 포인터
        int end = 1;    // 끝 포인터
        int sum = 1;    // 현재 합
        int count = 0;  // 연속된 자연수의 합이 N인 경우의 수

        while (start <= N) {
            if (sum == N) {
                count++; // 조건을 만족하는 경우
                sum -= start; // 시작 값을 빼고
                start++;      // 시작 포인터를 증가
            } else if (sum > N) {
                sum -= start; // 합이 초과하면 시작 값을 빼고
                start++;      // 시작 포인터를 증가
            } else {
                end++;        // 합이 부족하면 끝 포인터를 증가
                sum += end;   // 끝 값을 더함
            }
        }

        System.out.println(count);
        sc.close();
    }
}
