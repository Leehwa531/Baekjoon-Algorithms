import java.util.Scanner;

public class JAVA_25404 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int X = sc.nextInt(); // 총 금액
    int N = sc.nextInt(); // 물품 개수
    
    if (Checking(X, N, sc)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
    sc.close(); // Scanner 닫기
  }

  public static boolean Checking(int total, int num, Scanner sc) {
    int sum = 0;

    for (int i = 0; i < num; i++) {
      int price = sc.nextInt(); // 물건 가격
      int piece = sc.nextInt(); // 물건 개수
      sum += price * piece;
    }

    return total == sum; // 총합 비교
  }
}
