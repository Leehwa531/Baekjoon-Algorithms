import java.util.Scanner;

public class JAVA_27866 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String S = sc.next();
    int num = sc.nextInt();

    System.out.println(S.charAt(num-1));
    sc.close();
  }
}
