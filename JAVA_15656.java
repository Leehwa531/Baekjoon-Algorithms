import java.io.*;
import java.util.*;

public class JAVA_15656 {
    static int n, m;
    static int[] nums, result; // 선택된 숫자를 저장할 배열 추가
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        nums = new int[n];
        result = new int[m]; // 결과 저장용 배열 초기화

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums); // 오름차순 출력을 위해 정렬
        combi(0);    //+1 순i시작
        System.out.println(sb); // 결과 출력
    }

    static void combi(int depth) {
        if (depth == m) { // m개를 모두 선택했을 때
            for (int num : result) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
                result[depth] = nums[i];
                combi(depth+1);
            
        }

        
    }
}
