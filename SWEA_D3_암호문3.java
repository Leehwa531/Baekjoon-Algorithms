import java.util.*;

public class SWEA_D3_암호문3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<Integer> list;

    for (int testCase = 0; testCase < 10; testCase++) {
      int N = sc.nextInt();
      list = new LinkedList<>();

      // 원본 암호문 입력
      for (int i = 0; i < N; i++) {
        list.add(sc.nextInt());
      }

      int M = sc.nextInt(); // 명령어 개수 입력

      for (int i = 0; i < M; i++) {
        String command = sc.next(); // 명령어 읽기

        switch (command) {
          case "I": // 삽입 (Insert)
            int x = sc.nextInt();
            int y = sc.nextInt();
            for (int j = 0; j < y; j++) {
              list.add(x + j, sc.nextInt());
            }
            break;

          case "D": // 삭제 (Delete)
            int idx = sc.nextInt();
            int count = sc.nextInt();
            for (int j = count - 1; j >= 0; j--) { // 뒤에서부터 삭제
              if (idx + j < list.size()) { // 인덱스 유효성 체크
                list.remove(idx + j);
              }
            }
            break;

          case "A": // 추가 (Append)
            int addCount = sc.nextInt();
            for (int j = 0; j < addCount; j++) {
              list.add(sc.nextInt());
            }
            break;
        }
      }

      System.out.print("#" + (testCase + 1) + " ");
      for (int j = 0; j < 10; j++) { // 상위 10개 출력
        System.out.print(list.get(j) + " ");
      }
      System.out.println(); // 줄바꿈 추가
    }

    sc.close();
  }
}
