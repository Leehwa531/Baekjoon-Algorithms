package DP;

import java.util.*;

public class JAVA_11725 {
  static Queue<Integer> queue = new LinkedList<>();
  static boolean[] visited;
  static List<Integer>[] node;
  static int[] parent;
  static int n;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    parent = new int[n + 1];
    visited = new boolean[n + 1];
    node = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      node[i] = new ArrayList<>();
  }

    for(int i = 0 ; i<n-1 ; i++){
      int x = sc.nextInt();
      int y = sc.nextInt();
      node[x].add(y);
      node[y].add(x);
    }

    BFS();
  }

  static void BFS(){
    queue.offer(1);
    visited[1] = true;

    while(!queue.isEmpty()){
      int cur = queue.poll();

      for(int next : node[cur]){
        if(!visited[next]){
          visited[next] = true;
          parent[next] = cur;
          queue.add(next);
        }
      }
    }

    for(int i = 2 ; i<=n ; i++){
      System.out.println(parent[i]);
    }
  }
}
