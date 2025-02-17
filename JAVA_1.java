import java.util.Scanner;

public class JAVA_1 {

    static boolean[] visited;   // 순열 구하기용 백트래킹 방문 여부 체크
    static int[][] order; 
    static int[] list;
    static int permuOrder = 0;
    static int permuSize = 1;

    static int n;
    static int m;
    static int minSum = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int k = sc.nextInt();

        visited = new boolean[k];   // k개의 숫자에 대한 방문 체크
        list = new int[k]; // 현재 순열 저장 배열

        int[][] a = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int[][] rcs = new int[k][3];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 3; j++) {
                rcs[i][j] = sc.nextInt();
            }
        }

        int result = turn(rcs, a, k);
        System.out.println(result);
        sc.close();
    }

    static int turn(int[][] rcs, int[][] a, int k) {

        for (int i = 1; i <= k; i++) {
            permuSize *= i;
        }
        order = new int[permuSize][k];
        permuOrder = 0; // 순열 저장 위치 초기화

        // 백트래킹을 이용하여 순열 생성
        ordering(0, k);

        for(int index = 0; index < permuSize ; index++){
          int r = rcs[order[index][0]][0];
          int c = rcs[order[index][1]][1];
          // int s = rcs[order[index][2]][2];
          
          for(int depth = 1 ; depth <= k ; depth++){

            for(int i=r+depth ; i>=r-depth ; i--){
              if(i==r+depth) continue;
              a[i][c-depth] = a[i+1][c-depth];
            }
            for(int i=r-depth ; i<=r+depth ; i++){
              if(i==r-depth) continue;
              a[i][c+depth] = a[i+1][c+depth];
            }
            for(int i=c+depth ; i>=c-depth ; i--){
              if(i==c+depth) continue;
              a[i][r-depth] = a[i+1][r-depth];
            }
            for(int i=c+depth ; i<=c-depth ; i++){
              if(i==c+depth) continue;
              a[i][r-depth] = a[i+1][r-depth];
            }
            
          }

          //a배열의 행의 최소를 구하기
          for(int i = 0 ; i<n ; i++){
            int sum = 0;
            for(int j = 0 ; j<m ; j++){
              sum += a[i][j];
            }
            minSum =  Math.min(minSum,sum);
          }

        }
    

        return minSum;
    }

    static void ordering(int depth, int k) {
        if (depth == k) {  // k개의 숫자를 모두 모으면 순열 완성
            order[permuOrder] = list.clone(); // 현재 순열 저장
            permuOrder++; // 다음 순열 저장 위치 증가
            return;
        }

        for (int i = 0; i < k; i++) {
            if (!visited[i]) { // 방문하지 않았다면 사용
                visited[i] = true; // 방문 체크
                list[depth] = i; // 순열에 추가
                ordering(depth + 1, k); // 다음 숫자 선택 (재귀 호출)
                visited[i] = false; // 백트래킹 (되돌리기)
            }
        }
    }
}

