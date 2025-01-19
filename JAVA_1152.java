import java.util.*;

public class JAVA_1152 {
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim(); // 입력 문자열의 앞뒤 공백 제거
        sc.close();

        if (input.isEmpty()) {
            System.out.println(0);
        } else {
            String[] words = input.split(" "); // 공백을 기준으로 문자열 분리
            System.out.println(words.length);
        }
    }
}
