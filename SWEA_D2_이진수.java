import java.util.Scanner;

public class SWEA_D2_이진수 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();

    for (int testCase = 0; testCase < T; testCase++) {
      // int size = sc.nextInt(); // 16진수 길이
      String hex = sc.next();  // 16진수 문자열
      
      StringBuilder binary = new StringBuilder();

      for (char hexChar : hex.toCharArray()) {
        int decimal = Character.digit(hexChar, 16); // 16진수 문자 → 10진수 변환
        String binFragment = String.format("%4s", Integer.toBinaryString(decimal)).replace(' ', '0'); // 4비트 변환
        binary.append(binFragment);
      }

      System.out.println("#" + (testCase + 1) + " " + binary.toString());
    }

    sc.close();
  }
}
