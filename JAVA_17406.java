import java.util.Scanner;

public class JAVA_17406 {

    static boolean[] visited;   // 순열 구하기용 백트래킹 방문 여부 체크
    static int[][] order; 
    static int[] list;
    static int permuOrder = 0;
    static int permuSize = 1;

    static int n, m;
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

        // 순열을 사용하여 회전 연산 적용
        for (int index = 0; index < permuSize; index++) {
            int[][] tempA = copyArray(a); // 원본 배열 유지
            for (int i = 0; i < k; i++) {
                int r = rcs[order[index][i]][0];
                int c = rcs[order[index][i]][1];
                int s = rcs[order[index][i]][2];

                rotate(tempA, r, c, s); // 배열 회전
            }
            // 회전 후 최소 행 합 갱신
            minSum = Math.min(minSum, getMinRowSum(tempA));
        }

        return minSum;
    }

    // 배열을 회전하는 함수
    static void rotate(int[][] arr, int r, int c, int s) {
        for (int depth = 1; depth <= s; depth++) {
            int temp = arr[r - depth][c - depth];

            // 왼쪽 열 (위에서 아래로)
            for (int i = r - depth; i < r + depth; i++) {
                arr[i][c - depth] = arr[i + 1][c - depth];
            }
            // 아래 행 (왼쪽에서 오른쪽으로)
            for (int i = c - depth; i < c + depth; i++) {
                arr[r + depth][i] = arr[r + depth][i + 1];
            }
            // 오른쪽 열 (아래에서 위로)
            for (int i = r + depth; i > r - depth; i--) {
                arr[i][c + depth] = arr[i - 1][c + depth];
            }
            // 위쪽 행 (오른쪽에서 왼쪽으로)
            for (int i = c + depth; i > c - depth + 1; i--) {
                arr[r - depth][i] = arr[r - depth][i - 1];
            }

            arr[r - depth][c - depth + 1] = temp;
        }
    }

    // 배열 복사 함수
    static int[][] copyArray(int[][] original) {
      int[][] copy = new int[n + 1][m + 1];
      for (int i = 0; i <= n; i++) {
          copy[i] = original[i].clone(); // 한 줄씩 복사
      }
      return copy;
    }
  

    // 행의 최소 합 계산
    static int getMinRowSum(int[][] arr) {
        int minRowSum = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= m; j++) {
                sum += arr[i][j];
            }
            minRowSum = Math.min(minRowSum, sum);
        }
        return minRowSum;
    }

    // 순열 생성 함수 (백트래킹)
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
