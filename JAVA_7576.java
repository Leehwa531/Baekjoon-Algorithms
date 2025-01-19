import java.io.*;
import java.util.*;

public class JAVA_7576 {
    public static int[][] box;          // 토마토 상태
    public static int[][] visitedDay;   // 며칠 걸렸는지
    public static int n, m;             // 토마토 상자 크기

    // BFS용 큐
    public static Queue<int[]> queue = new LinkedList<>();

    // 방향 벡터
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        visitedDay = new int[n][m];
        box = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.add(new int[]{i, j}); // 익은 토마토의 위치 추가
                    visitedDay[i][j] = 0;      // 초기화
                }
            }
        }

        System.out.println(BFS());
    }

    public static int BFS() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 토마토 상자 범위 검사
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    // 익지 않은 토마토인지 검사
                    if (box[nx][ny] == 0) {
                        box[nx][ny] = 1; // 토마토를 익은 상태로 변경
                        visitedDay[nx][ny] = visitedDay[x][y] + 1;  // 하루 추가
                        queue.add(new int[]{nx, ny});  // 큐에 추가
                    }
                }
            }
        }

        int max = 0; // 최소 일수
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    return -1; // 익지 않은 토마토가 남아있으면 -1 반환
                }
                max = Math.max(max, visitedDay[i][j]);
            }
        }
        return max;
    }
}
