import java.util.Scanner;

public class JAVA_10093 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        // A와 B 정렬
        long min = Math.min(A, B);
        long max = Math.max(A, B);

        // 두 수 사이의 숫자 개수 출력
        System.out.println(max - min > 1 ? max - min - 1 : 0);

        // 두 수 사이의 숫자 출력
        if (max - min > 1) {
            for (long i = min + 1; i < max; i++) {
                System.out.print(i + " ");
            }
        }
    }
}
