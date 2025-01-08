import java.util.Scanner;

public class JAVA_1000 {
  public static void main(String[] args) {
    // Scanner 객체 생성
    Scanner sc = new Scanner(System.in);
    
    // 문자열 입력
    int A = sc.nextInt();
    int B = sc.nextInt();

    System.out.println(A+B);

    sc.close();
  }
}