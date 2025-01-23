import java.util.Scanner;

//개똥같은 수학문제

public class JAVA_15236 {
  public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		System.out.println((N * (N + 1) * (N + 2)) / 2);
		in.close();
  }
}
