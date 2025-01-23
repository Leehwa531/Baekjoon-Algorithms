import java.util.*;

public class JAVA_2178 {
  public static int[][] maze;
  public static boolean[][] visited;

  //방향 벡터
  public static int[] dx = {-1,1,0,0}; // 아래 위
  public static int[] dy = {0,0,-1,1}; // 왼쪽 오른쪽

  public static int n,m; //미로 크기

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); // 스캐너띠
    n = sc.nextInt();  //행 개수
    m = sc.nextInt();  //열 개수
    sc.nextLine(); //버퍼 지우기 because \n(개행문자)

    maze = new int[n][m]; //미로 정보
    visited = new boolean[n][m]; //방문 여부

    //미로 정보 입력받기
    for(int i = 0 ; i<n;i++){
      String line = sc.nextLine();
      for(int j = 0 ; j<m ; j++){
        maze[i][j] = line.charAt(j) -'0';
      }
    }

    System.out.println(BFS(0,0));
    sc.close();
  }
  public static int BFS(int startX,int startY){
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{startX,startY});  // 시작점 큐에 추가
    visited[startX][startY] = true;     //시작점 방문표시

    int[][] distance = new int[n][m];
    distance[startX][startY] = 1;

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();   //큐에 값 하나 꺼내기
      int x = cur[0];   //꺼낸 x값
      int y = cur[1];   //꺼낸 y값

      //목적지 도달시 거리 반환
      if(x == n-1 && y == m-1){
        return distance[x][y];
      }

      for(int i =0;i<4;i++){
        int nx = x+dx[i];
        int ny = y+dy[i];

        //유효 좌표확인
        if(nx>=0 && ny>=0 && nx<n && ny<m){
          //방문 안했고, 1이면 방문 가능
          if(!visited[nx][ny] && maze[nx][ny] == 1){
            visited[nx][ny] = true;
            distance[nx][ny] = distance[x][y] + 1;
            queue.add(new int[]{nx,ny});
          }
        }
      }
    }
    return -1;
  }
}
