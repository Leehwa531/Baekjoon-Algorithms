import java.util.*;

public class JAVA_7569 {
    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,-1,1};

    static int n, m, h;
    static int[][][] map;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt(); // 가로 (열)
        n = sc.nextInt(); // 세로 (행)
        h = sc.nextInt(); // 높이 (층)
        map = new int[h][n][m];

        // 입력 받기 & 익은 토마토를 큐에 삽입
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    map[i][j][k] = sc.nextInt();
                    if (map[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k}); // 익은 토마토 큐에 추가
                    }
                }
            }
        }

        // BFS 실행
        BFS();

        int maxDay = Integer.MIN_VALUE;
        
        // 모든 토마토가 익었는지 확인 & 최대 날짜 찾기
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[i][j][k] == 0) { // 익지 않은 토마토가 있으면 -1 출력
                        System.out.println(-1);
                        return;
                    }
                    maxDay = Math.max(maxDay, map[i][j][k]); // 최대 날짜 찾기
                }
            }
        }

        // 최종 결과 출력 (첫 날이 1이므로 1을 빼줘야 함)
        System.out.println(maxDay - 1);
    }

    static void BFS() {
        while (!queue.isEmpty()) {
            int[] xyz = queue.poll();
            int z = xyz[0];
            int y = xyz[1];
            int x = xyz[2];

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (nz >= 0 && ny >= 0 && nx >= 0 && nz < h && ny < n && nx < m) {
                    if (map[nz][ny][nx] == 0) { // 익지 않은 토마토
                        map[nz][ny][nx] = map[z][y][x] + 1; // 날짜 업데이트
                        queue.offer(new int[]{nz, ny, nx});
                    }
                }
            }
        }
    }
}
