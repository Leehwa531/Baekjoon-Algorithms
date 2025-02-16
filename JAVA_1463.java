import java.util.Scanner;

public class JAVA_1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 0;

        for(int i = 2 ; i<=n ; i++){

          //-1부터 시작해서 /2 /3 으로 확장해나감
          // /2, /3은 2부터 시작할때 안될 수도 있기때문에 제일먼저 만만한 -1로 시작.
          //Math.min으로 비교해서 더 작은거 선택하면 되기 때문.
          
          dp[i] = dp[i-1] + 1;

          if(i % 2 == 0)
          dp[i] = Math.min(dp[i], dp[i/2] + 1);

          if(i % 3 == 0)
          dp[i] = Math.min(dp[i],dp[i/3] + 1);

        }


        System.out.println(dp[n]);
    }
}