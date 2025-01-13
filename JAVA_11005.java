import java.io.*;
import java.util.*;

public class JAVA_11005 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        // 리스트에 0~9, A~Z까지 저장
        for (int i = 0; i <= 9; i++) {
            list.add(String.valueOf(i));
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            list.add(String.valueOf(c));
        }

        // 한 줄 입력받기
        String input = br.readLine();
        String[] tokens = input.split(" ");
        int N = Integer.parseInt(tokens[0]);
        int B = Integer.parseInt(tokens[1]);

        // 진법 변환
        while (N > 0) {
            int remain = N % B; // 나머지 계산
            sb.append(list.get(remain)); // 리스트에서 대응되는 문자 추가
            N /= B; // 몫 갱신
        }

        // 결과를 뒤집어 올바른 순서로 출력
        System.out.println(sb.reverse().toString());
    }
}
