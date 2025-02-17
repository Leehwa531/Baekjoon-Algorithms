import java.util.*;

public class JAVA_7562 {
  static int[] dx = {-2,-1,1,2,-2,-1,1,2};
  static int[] dy = {-1,-2,-2,-1,1,2,2,1};

  static int l;
  static boolean[][] visited;
  static int[][] map;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int testcase = sc.nextInt();

    for(int t = 0 ; t < testcase ; t++){
      l = sc.nextInt(); //체스판의 크기
      map = new int[l][l];  //체스판 크기 초기화
      visited = new boolean[l][l];  //체스 칸 방문여부 초기화


      int[] knightNow = { sc.nextInt(), sc.nextInt()};
      int[] goal= { sc.nextInt(), sc.nextInt()};

      if(knightNow[0] == goal[0] && knightNow[1] == goal[1]){
        System.out.println(0);
        continue;
      }

      System.out.println(BFS(knightNow[0],knightNow[1], goal));
    }
    sc.close();
  }

  static int BFS(int startY, int startX, int[] goal){
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {startY,startX});
    visited[startY][startX] = true;

    while (!queue.isEmpty()) {
      int[] xy = queue.poll();
      int y = xy[0];
      int x = xy[1];

      for(int i = 0 ; i<8 ; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];

        if (ny >=0 && nx >=0 && ny < l && nx < l) {
          if(visited[ny][nx] == false){
            if(ny == goal[0] && nx == goal[1]){
              return map[y][x]+1;
            }else{
              map[ny][nx] = map[y][x]+1;
              visited[ny][nx] = true;
              queue.add(new int[] {ny,nx});
            }
          }
        }
      }
    }
    return 0;
  }
}
