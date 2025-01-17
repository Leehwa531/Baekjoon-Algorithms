import java.util.Scanner;

public class JAVA_5555 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 찾고자 하는 문자열
        String target = sc.nextLine();
        
        // 반지의 개수
        int N = sc.nextInt();
        sc.nextLine(); // nextInt 후 개행문자 처리
        
        int count = 0;  // 찾고자 하는 문자열을 포함하는 반지의 개수
        
        // 각 반지에 대해 처리
        for (int i = 0; i < N; i++) {
            String ring = sc.nextLine();  // 반지 문자열
            String doubledRing = ring + ring;  // 원형을 처리하기 위해 두 번 이어 붙임
            
            // 찾고자 하는 문자열이 이 두 번 이어진 문자열에 포함되는지 확인
            if (doubledRing.contains(target)) {
                count++;  // 포함되면 카운트 증가
            }
        }
        
        // 결과 출력
        System.out.println(count);
        sc.close();
    }
}
