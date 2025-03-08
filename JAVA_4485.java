import java.io.*;
import java.util.*;

public interface JAVA_4485 {
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int problemCount = 1;

    while(true){
      int n = Integer.parseInt(br.readLine().trim());
      if(n == 0) break;

      int[][] map = new int[n][n];
      for(int i = 0 ; i< n ; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0 ; j<n; j++){
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      // 다익스트라 ㄱㄱ탱
      int answer = dijkstra(n,map);
      System.out.println("Problem " + problemCount + ": " + answer);
      problemCount++;
    }
  }
  private static int dijkstra(int n, int[][] map) {
    int[][] distance = new int[n][n]; //거리 저장 배열 초기화

    for (int i = 0; i<n; i++){
      Arrays.fill(distance[i], Integer.MAX_VALUE);  //최단거리안에 최대값으로 초기화
    }

    distance[0][0] = map[0][0]; //시작지점 거리비용 넣기

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(0, 0, map[0][0]));

    while(!pq.isEmpty()){
      Node node = pq.poll();
      int x = node.x;
      int y = node.y;
      int cost = node.cost;

      //더 작은 비용으로 방문했다면 무시
      if(distance[x][y] < cost){
        continue;
      }

      for(int i = 0 ; i<4 ; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];

        if(nx<0 || nx >= n || ny < 0 || ny >= n){
          continue;
        }

        
        int newCost = cost + map[nx][ny];

        //적은 비용일 경우.
        if(distance[nx][ny] > newCost){
          distance[nx][ny] = newCost;
          pq.offer(new Node(nx, ny, newCost));
        }
      }
    }


    return distance[n-1][n-1];
  }

  // static class Node implements Comparable<Node>{
  //   int x, y, cost;

  //   public Node(int x, int y, int cost) {
  //     this.x = x;
  //     this.y = y;
  //     this.cost = cost;
  //   }

  //   @Override
  //   public int compareTo(Node other){
  //     return this.cost - other.cost;
  //   }
  // }






  static class Node implements Comparable<Node>{
    int x;
    int y;
    int cost;

    Node(int x, int y, int cost){
      this.x = x;
      this.y = y;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
      return this.cost - other.cost;
    }

    


  }
  
}








