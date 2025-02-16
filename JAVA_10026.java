import java.util.*;

public class JAVA_10026 {
  static int n;
  static boolean[][] visited1;
  static boolean[][] visited2;
  static char[][] RGB,RXB;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, 1, -1};
  static Queue<int[]> queue1= new LinkedList<>();
  static Queue<int[]> queue2= new LinkedList<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    sc.nextLine();
    RGB = new char[n][n];
    RXB = new char[n][n];
    visited1 = new boolean[n][n];
    visited2 = new boolean[n][n];
    for(int i = 0 ; i<n ; i++){
      char[] line = sc.nextLine().toCharArray();
      for(int j = 0 ; j<n ; j++){
        RGB[i][j] = line[j];
        if(line[j]=='G'){
          RXB[i][j] = 'R';
        }else{
          RXB[i][j] = line[j];
        }
      }
    }
    int count1 = 0;
    int count2 = 0;
    for(int i = 0 ; i<n ; i++){
      for(int j = 0 ; j<n ; j++){
        if(!visited1[i][j]){
          switch (RGB[i][j]) {
            case 'R':
              queue1.offer(new int[] {i,j});
              visited1[i][j] = true;
              BFS1('R');
              break;
            case 'G':
              queue1.offer(new int[] {i,j});
              visited1[i][j] = true;
              BFS1('G');
              break;
            case 'B':
              queue1.offer(new int[] {i,j});
              visited1[i][j] = true;
              BFS1('B');
              break;
          }
          count1++;
        }

        if(!visited2[i][j]){
          switch (RXB[i][j]) {
            case 'R':
              queue2.offer(new int[] {i,j});
              visited2[i][j] = true;
              BFS2('R');
              break;
            case 'B':
              queue2.offer(new int[] {i,j});
              visited2[i][j] = true;
              BFS2('B');
              break;
          }
          count2++;
        }
      }
    }
    System.out.println(count1 + " " + count2);
    sc.close();
  }

  static void BFS1(char c){
    while(!queue1.isEmpty()){
      int[] xy = queue1.poll();
      int y = xy[0];
      int x = xy[1];

      for(int i = 0 ; i<4 ; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx>=0 && ny>=0 && nx<n && ny<n){
          if(visited1[ny][nx] == false && RGB[ny][nx] ==c){
            visited1[ny][nx] = true;
            queue1.add(new int[] {ny,nx});
          }
        }
      }
    }
  }

  static void BFS2(char c){
    
    while(!queue2.isEmpty()){
      int[] xy = queue2.poll();
      int y = xy[0];
      int x = xy[1];

      for(int i = 0 ; i<4 ; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx>=0 && ny>=0 && nx<n && ny<n){
          if(visited2[ny][nx] == false && RXB[ny][nx] ==c){
            visited2[ny][nx] = true;
            queue2.add(new int[] {ny,nx});
          }
        }
      }
    }
  }
}
