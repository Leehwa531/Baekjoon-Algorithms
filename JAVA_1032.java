import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JAVA_1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());  // 입력받을 파일 이름 개수
        String[] fileName = new String[N];        // N개만큼 문자열 배열 생성
        
        // 파일 이름 입력받기
        for (int i = 0; i < N; i++) {
            fileName[i] = br.readLine();
        }
        
        // 동일한 문자 찾기
        StringBuilder sameWord = new StringBuilder();  // 결과 문자열
        
        for (int i = 0; i < fileName[0].length(); i++) {
            char currentChar = fileName[0].charAt(i);  // 첫 번째 문자열의 i번째 문자
            boolean isSame = true;
            
            // 모든 문자열의 i번째 문자가 동일한지 확인
            for (int j = 1; j < N; j++) {
                if (fileName[j].charAt(i) != currentChar) {
                    isSame = false;
                    break;
                }
            }
            
            // 동일한 문자라면 추가, 아니면 '?' 추가
            if (isSame) {
                sameWord.append(currentChar);
            } else {
                sameWord.append('?');
            }
        }
        
        // 결과 출력
        System.out.println(sameWord);
    }
}
