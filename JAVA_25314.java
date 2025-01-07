import java.util.Scanner;

public class JAVA_25314 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 입력 받기
    sc.close(); // Scanner 닫기
    
    for (; N > 0; N -= 4) { // 초기화 생략
      System.out.print("long "); // 한 줄에 출력
    }
    System.out.println("int"); // 마지막에 int 출력
  }
}
