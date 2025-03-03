import java.util.*;

public class JAVA_2281 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 초기값 설정

        for (int i = 0; i < n; i++) {
            int lineSum = 0;
            for (int j = i; j < n; j++) {
                if (lineSum == 0) {
                    lineSum = nums[j];
                } else {
                    lineSum += nums[j] + 1;
                }

                if (lineSum > m) break; // 줄을 넘어서면 중단

                int blank = m - lineSum;
                int cost = blank * blank; // 공백의 제곱 비용

                if (j == n - 1) cost = 0; // 마지막 줄은 공백 패널티 없음

                dp[j + 1] = Math.min(dp[j + 1], dp[i] + cost);
            }
        }

        System.out.println(dp[n]);
    }
}
