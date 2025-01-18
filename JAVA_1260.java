import java.util.*;

public class JAVA_1260 {
  public static boolean[] visited1 = new boolean[100];
  public static boolean[] visited2= new boolean[100];
  public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); //정점 개수
    int M = sc.nextInt(); //간선 개수
    int V = sc.nextInt(); //시작 정점

    //간선 입력 받기
    for (int i = 0 ; i < M ; i ++){
      int x = sc.nextInt();
      int y = sc.nextInt();
      graph.get(x).add(y);
      graph.get(y).add(x); // 무방향 그래프 이므로 추가.
    }

    DFS(V);
    BFS(V);
  }

  public static void DFS(int V){
    visited1[V] = true;
    System.out.println(V);

    for ( int i : graph.get(V)){
      if (!visited1[i]){
        DFS(i);
      }
    }
  }

    public static void BFS(int V){
      visited2[V] = true;
      System.out.println(V);

      Queue<Integer> queue = new LinkedList<Integer>();
      queue.add(V);

      while(queue.isEmpty()){
        int node = queue.poll();
        System.out.println(node + " ");

        for(int i : graph.get(node)){
          if (!visited2[i]){
            queue.add(i);
            visited2[i] = true;
          }
        }
      }
    }

}
