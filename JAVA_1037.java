import java.util.Scanner;
import java.util.Arrays;

public class JAVA_1037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 약수의 개수 입력
        int n = sc.nextInt();
        
        // 약수들을 저장할 배열 생성
        int[] divisors = new int[n];
        
        // 약수들 입력 받기
        for(int i = 0; i < n; i++) {
            divisors[i] = sc.nextInt();
        }
        
        // 가장 작은 약수와 가장 큰 약수 찾기
        Arrays.sort(divisors);  // 배열 정렬
        
        // 결과 계산 (가장 작은 수 * 가장 큰 수)
        long result = (long)divisors[0] * divisors[n-1];
        
        // 결과 출력
        System.out.println(result);
        
        sc.close();
    }
}