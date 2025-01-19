import java.util.*;

public class JAVA_11724 {
  public static int N,M;
  public static List<List<Integer>> graph = new ArrayList<>();
  public static boolean[] visited;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();
    int count = 0;

    visited = new boolean[N+1];

    //그래프 초기화
    for(int i = 0 ; i < N + 1 ; i++){
      graph.add(new ArrayList<>());
    }
    
    for(int i = 0 ; i< M ; i++){
      int x = sc.nextInt();
      int y = sc.nextInt();
      graph.get(x).add(y);
      graph.get(y).add(x); // 무방향 그래프이므로 반대쪽도 추가
    }
    for(int i = 1 ; i<N+1 ; i++){
      if(!visited[i]){
        DFS(i);
        count++;
      }
    }
    System.out.println(count);
    sc.close();
  }
  public static void DFS(int node){
    visited[node] = true;

    for(int i = 0 ; i < graph.get(node).size() ; i++){
      int next = graph.get(node).get(i);
      if(!visited[next]){
        DFS(next);
      }
    }
  }
}
