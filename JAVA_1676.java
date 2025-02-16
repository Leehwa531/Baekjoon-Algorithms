import java.util.Scanner;

public class JAVA_1676 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int count = 0;
    
    // 5, 25, 125, ... 로 나눈 몫을 모두 더하면 5의 개수가 됨x
    for (int i = 5; i <= n; i *= 5) {
      count += n / i;
    }
    
    System.out.println(count);
  }
}
