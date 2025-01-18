import java.util.*;

public class JAVA_1260 {
    public static boolean[] visited1;
    public static boolean[] visited2;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 정점 개수
        int M = sc.nextInt(); // 간선 개수
        int V = sc.nextInt(); // 시작 정점

        // 방문 배열 초기화
        visited1 = new boolean[N + 1];
        visited2 = new boolean[N + 1];

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>()); // 각 정점에 대해 리스트 초기화
        }

        // 간선 입력 받기
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x); // 무방향 그래프이므로 양방향 추가
        }

        // 정점 번호 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        // DFS 호출
        DFS(V);
        System.out.println();

        // BFS 호출
        BFS(V);
        sc.close();
    }

    public static void DFS(int V) {
        visited1[V] = true; // 현재 정점 방문 표시
        System.out.print(V + " "); // 방문한 정점 출력

        for (int i : graph.get(V)) { // 현재 정점과 연결된 정점 순회
            if (!visited1[i]) { // 방문하지 않은 정점 방문
                DFS(i); // 재귀 호출
            }
        }
    }

    public static void BFS(int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visited2[V] = true; // 시작 정점 방문 표시

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " "); // 방문한 정점 출력

            for (int i : graph.get(node)) { // 현재 정점과 연결된 정점 순회
                if (!visited2[i]) { // 방문하지 않은 정점 방문
                    queue.add(i);
                    visited2[i] = true; // 방문 표시
                }
            }
        }
    }
}
