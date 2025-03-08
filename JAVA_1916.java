import java.io.*;
import java.util.*;

public class JAVA_1916 {
    static final int INF = Integer.MAX_VALUE;
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 노드 개수
        int M = Integer.parseInt(br.readLine()); // 간선 개수

        // 그래프 초기화 (N+1개 생성)
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            String[] nums = br.readLine().split(" ");
            int start = Integer.parseInt(nums[0]);
            int end = Integer.parseInt(nums[1]);
            int cost = Integer.parseInt(nums[2]);
            graph.get(start).add(new Node(end, cost));
        }

        // 출발점과 도착점 입력
        String[] nums = br.readLine().split(" ");
        int start = Integer.parseInt(nums[0]);
        int end = Integer.parseInt(nums[1]);

        // 다익스트라 알고리즘 실행
        int lowLength = dijkstra(start, end, N);
        System.out.println(lowLength);
    }

    static int dijkstra(int start, int end, int N) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, INF); // 모든 거리 무한대로 초기화
        distance[start] = 0; // 출발 노드는 0으로 초기화

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.v;

            // 현재 노드의 거리가 이미 저장된 거리보다 크다면 무시
            if (distance[now] < cur.cost) {
                continue;
            }

            for (Node next : graph.get(now)) {
                int cost = distance[now] + next.cost; // 현재 노드를 거쳐가는 비용 계산

                // 더 짧은 거리 발견 시 업데이트
                if (cost < distance[next.v]) {
                    distance[next.v] = cost;
                    pq.offer(new Node(next.v, cost));
                }
            }
        }

        return distance[end]; // 최단거리 반환
    }

    static class Node implements Comparable<Node> {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost); // 우선순위 큐에서 비용 기준 정렬
        }
    }
}
