import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JAVA_1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            String line = br.readLine(); // 각 테스트 케이스마다 새로운 줄 읽기
            String[] tokens = line.split(" ");
            int num1 = Integer.parseInt(tokens[0]) % 10; // num1의 마지막 자리만 고려
            int num2 = Integer.parseInt(tokens[1]); // 지수

            if (num2 == 0) {
                System.out.println(1); // 지수가 0인 경우, 결과는 항상 1
                continue;
            }

            // 주기성을 이용한 계산
            int[] cycle = new int[4]; // 최대 주기는 4
            cycle[0] = num1;
            for (int j = 1; j < 4; j++) {
                cycle[j] = (cycle[j - 1] * num1) % 10;
            }

            // 주기의 인덱스를 이용해 결과 계산
            int cycleLength = (num2 - 1) % 4; // (지수 - 1) % 주기
            int result = cycle[cycleLength];

            System.out.println(result == 0 ? 10 : result); // 마지막 자리가 0이면 10 출력
        }
    }
}
