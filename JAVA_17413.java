import java.util.Scanner;

public class JAVA_17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder result = new StringBuilder();  // 최종 결과를 저장할 변수
        StringBuilder word = new StringBuilder();    // 태그 밖의 단어를 임시로 저장할 변수
        boolean inTag = false;                         // 현재 태그 내부인지 여부
        
        // 문자열의 각 문자를 순회
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            
            if (c == '<') { // 태그의 시작
                // 태그가 시작되기 전까지 모아둔 단어를 뒤집어서 결과에 추가
                result.append(word.reverse());
                word.setLength(0); // word 초기화
                inTag = true;
                result.append(c);  // '<' 자체는 결과에 추가
            } else if (c == '>') { // 태그의 끝
                inTag = false;
                result.append(c);  // '>'도 그대로 추가
            } else {
                if (inTag) {
                    // 태그 내부면 그대로 결과에 추가
                    result.append(c);
                } else {
                    // 태그 외부인 경우
                    if (c == ' ') {
                        // 공백이 나오면 현재까지 모은 단어를 뒤집어서 결과에 추가하고,
                        // 공백도 결과에 추가
                        result.append(word.reverse());
                        word.setLength(0);
                        result.append(c);
                    } else {
                        // 단어의 일부이므로 word에 추가
                        word.append(c);
                    }
                }
            }
        }
        // 반복문 종료 후 남은 단어가 있다면 뒤집어서 결과에 추가
        result.append(word.reverse());
        
        System.out.println(result.toString());
        sc.close();
    }
}
