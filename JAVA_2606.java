import java.util.*;

public class JAVA_2606 {
    public static boolean[] visited;
    public static List<List<Integer>> graph = new ArrayList<>();
    public static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 컴퓨터의 수 (노드의 개수)
        int M = sc.nextInt(); // 연결된 간선의 수

        // 방문 배열 초기화
        visited = new boolean[N + 1];

        // 그래프 초기화
        for (int i = 0; i <= N; i++) { // 0번 인덱스는 비워두고 1부터 N까지 사용
            graph.add(new ArrayList<>());
        }

        // 간선 입력 받기
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x); // 무방향 그래프
        }

        // DFS 실행
        DFS(1);
        System.out.println(count); // 감염된 컴퓨터 수 출력
    }

    public static void DFS(int V) {
        visited[V] = true;

        for (int i = 0; i < graph.get(V).size(); i++) {
            int y = graph.get(V).get(i);
            if (!visited[y]) {
                count++;
                DFS(y);
            }
        }
    }
}
