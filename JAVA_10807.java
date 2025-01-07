import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JAVA_10807 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 리스트 크기 입력
    List<Integer> list = new ArrayList<>();

    // 리스트에 값 추가
    for (int i = 0; i < N; i++) {
      list.add(sc.nextInt());
    }

    int findNum = sc.nextInt(); // 찾으려는 숫자 입력
    int count = 0;

    // 리스트에서 숫자 찾기
    for (int i = 0; i < N; i++) {
      if (list.get(i) == findNum) { // list[i] 대신 list.get(i) 사용
        count++;
      }
    }

    System.out.println(count); // 개수 출력
    sc.close(); // Scanner 닫기
  }
}
