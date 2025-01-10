import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class SWEA_D2_파리퇴치3 {
    // + 모양 스프레이를 위한 방향 배열 (상,하,좌,우)
    static int[] dxPlus = {-1, 1, 0, 0};
    static int[] dyPlus = {0, 0, -1, 1};
    
    // x 모양 스프레이를 위한 방향 배열 (대각선)
    static int[] dxCross = {-1, -1, 1, 1};
    static int[] dyCross = {-1, 1, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            // 배열 입력 받기
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int maxKill = 0;
            
            // 모든 위치에서 스프레이 시도
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // + 모양 스프레이로 잡을 수 있는 파리 수 계산
                    int plusSum = map[i][j];  // 중심점
                    for (int d = 0; d < 4; d++) {
                        for (int k = 1; k < M; k++) {
                            int nx = i + dxPlus[d] * k;
                            int ny = j + dyPlus[d] * k;
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                plusSum += map[nx][ny];
                            }
                        }
                    }
                    maxKill = Math.max(maxKill, plusSum);
                    
                    // x 모양 스프레이로 잡을 수 있는 파리 수 계산
                    int crossSum = map[i][j];  // 중심점
                    for (int d = 0; d < 4; d++) {
                        for (int k = 1; k < M; k++) {
                            int nx = i + dxCross[d] * k;
                            int ny = j + dyCross[d] * k;
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                crossSum += map[nx][ny];
                            }
                        }
                    }
                    maxKill = Math.max(maxKill, crossSum);
                }
            }
            
            System.out.println("#" + tc + " " + maxKill);
        }
    }
}