import java.util.*;

public class JAVA_14502 {
  static int n,m;
  static int[][] map, temp;
  static List<int[]> emptyList;
  static int maxSafe = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        temp = new int[n][m];
        emptyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 0) {
                    emptyList.add(new int[] { i, j });
                }
            }
        }
        makeWalls(0,0);
        System.out.println(maxSafe);
    }

    //입력받은 map에 벽을 세우자
    static void makeWalls(int depth,int start) {

        if (depth == 3) {
            BFS();
            return;
        }

        for (int i = start ; i < emptyList.size() ; i++){
          int[] pos = emptyList.get(i);
          map[pos[0]][pos[1]] = 1;
          makeWalls(depth+1, i+1);
          map[pos[0]][pos[1]] = 0;
        }
    }
    
    static void BFS() {
      boolean[][] visited = new boolean[n][m];
      Queue<int[]> queue = new LinkedList<>();

        for(int i = 0 ; i<n ; i++){
          for(int j = 0 ; j<m ; j++){
            temp[i][j] = map[i][j];
            if(map[i][j] == 2){
              queue.add(new int[] {i,j});
              visited[i][j] = true;
            }
          }
        }
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};

        while(!queue.isEmpty()){
          int[] xy = queue.poll();
          int y = xy[0];
          int x = xy[1];
          temp[y][x] = 2;

          for(int i = 0 ; i < 4 ; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<m && ny<n){
              if(!visited[ny][nx] && map[ny][nx] == 0){
                visited[ny][nx] = true;
                temp[ny][nx] = 2;
                queue.offer(new int[] {ny,nx});
              }
            }
          }
        }
        int count = 0;
        for(int i = 0 ; i<n ; i++){
          for(int j = 0 ; j<m ; j++){
            if(temp[i][j]==0){
              count++;
            }
          }
        }
        maxSafe = Math.max(maxSafe, count);
    }
}