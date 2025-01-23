import java.util.Scanner;
import java.util.TreeSet;

public class JAVA_1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 단어 개수
        sc.nextLine(); // 개행 문자 처리

        // TreeSet 생성 (길이 순 -> 사전순)
        TreeSet<String> set = new TreeSet<>((a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b); // 길이가 같으면 사전순 정렬
            }
            return Integer.compare(a.length(), b.length()); // 길이 순 정렬
        });

        // 단어 입력받아 TreeSet에 추가
        for (int i = 0; i < N; i++) {
            set.add(sc.nextLine());
        }

        // 결과 출력
        for (String word : set) {
            System.out.println(word);
        }
        sc.close();
    }
}
