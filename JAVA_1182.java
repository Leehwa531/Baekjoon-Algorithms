import java.util.Scanner;

public class JAVA_1182 {
    static int[] nums; // 입력 배열
    static int N, S;   // 배열 크기(N), 목표 합(S)
    static int count = 0; // 합이 S가 되는 부분수열의 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        N = sc.nextInt();
        S = sc.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        // 백트래킹 시작
        backtrack(0, 0);

        // 출력: 크기가 양수인 부분수열만 카운트
        if (S == 0) count--; // 공집합 제외
        System.out.println(count);

        sc.close();
    }

    // 백트래킹 메서드
    public static void backtrack(int index, int sum) {
        // 종료 조건: 배열의 끝까지 탐색한 경우
        if (index == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        // 현재 요소를 포함하는 경우
        backtrack(index + 1, sum + nums[index]);

        // 현재 요소를 포함하지 않는 경우
        backtrack(index + 1, sum);
    }
}
