import java.util.Scanner;

public class JAVA_8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수 입력
        sc.nextLine(); // 개행 문자 제거

        for (int i = 0; i < T; i++) {
            String str = sc.nextLine(); // OX 문자열 입력
            int score = 0; // 총 점수
            int consecutive = 0; // 연속된 O의 개수

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'O') {
                    consecutive++; // 연속된 O 개수 증가
                    score += consecutive; // 현재 점수에 추가
                } else {
                    consecutive = 0; // X가 나오면 연속 카운트 초기화
                }
            }

            System.out.println(score); // 각 테스트 케이스 결과 출력
        }

        sc.close();
    }
}
