import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력 받기

    for (int t = 0; t < T; t++) { // T 테스트 케이스만큼 반복
      String S = br.readLine(); // 문자열 입력 받기
      int K = Integer.parseInt(br.readLine()); // 연산 횟수 입력 받기
      String[] operations = br.readLine().split(" "); // K개의 연산을 공백으로 분리
      
      // 문자열을 StringBuilder로 초기화
      StringBuilder sb = new StringBuilder(S);
      
      // 연산 처리
      for (String op : operations) {
        int value = Integer.parseInt(op);
        
        if (value > 0) {
          // X > 0: 첫 번째 글자를 뒤로 이동
          value %= sb.length(); // 이동량 최적화
          sb.append(sb.substring(0, value)); // 첫 value개의 문자를 뒤로 추가
          sb.delete(0, value); // 앞의 value개의 문자 제거
        } else if (value < 0) {
          // X < 0: 마지막 글자를 앞으로 이동
          value = (-value) % sb.length(); // 이동량 최적화
          sb.insert(0, sb.substring(sb.length() - value)); // 마지막 value개의 문자를 앞으로 추가
          sb.delete(sb.length() - value, sb.length()); // 뒤의 value개의 문자 제거
        }
      }

      // 결과 출력
      System.out.println(sb.toString());
    }
  }
}
