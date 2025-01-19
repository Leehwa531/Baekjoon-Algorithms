import java.util.*;

public class JAVA_1697 {
    public static int N, K;
    public static int[] move = {0, -1, 1};
    public static int[] visited = new int[100001]; // 0부터 100000까지
    public static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        System.out.println(BFS());
    }

    public static int BFS() {
        queue.add(N);
        visited[N] = 1; // 시작 위치를 방문으로 표시

        while (!queue.isEmpty()) {
            int start = queue.poll();

            // 그 숫자를 찾았으면
            if (start == K) {
                return visited[start] - 1; // 초기값 1을 빼줌
            }

            for (int i = 0; i < 3; i++) {
                int direct;
                if (i == 0) {
                    direct = 2 * start; // 인덱스 0이면 2를 곱함
                } else {
                    direct = start + move[i];
                }

                // 범위 내 && 방문하지 않은 경우
                if (direct >= 0 && direct < visited.length && visited[direct] == 0) {
                    visited[direct] = visited[start] + 1;
                    queue.add(direct);
                }
            }
        }
        return 0; // 실행되지 않을 코드
    }
}
