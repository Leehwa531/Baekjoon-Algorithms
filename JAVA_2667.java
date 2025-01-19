import java.util.*;

public class JAVA_2667 {
  public static int[][] map;
  public static boolean[][] visited;

  public static int N,count;

  //벡터 좌표
  public static int[] dx = {-1,1,0,0};
  public static int[] dy = {0,0,-1,1};
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt(); // 맵 크기 입력 받기
    sc.nextLine(); // 개행 문자 컷!
    map = new int[N][N];
    visited = new boolean[N][N];

    //맵 정보 입력 받기
    for(int i = 0 ; i < N ; i++){
      String line = sc.nextLine();
      for(int j = 0 ; j < N ; j ++){
        map[i][j] = line.charAt(j) - '0';
      }
    }
    
    //연결 되어있는 집 개수 저장할 results변수 선언.
    List<Integer> results = new ArrayList<>();

    //지도 전체 순회, 흠.. 시간복잡도 엔제곱띠..
    for(int i = 0 ; i < N ; i++){
      for(int j = 0 ; j < N ; j ++){
        if(!visited[i][j] && map[i][j] == 1){
          count = 0;    //단지별 집 개수 초기화 init
          DFS(i,j); //재귀 ㅈ뺑이
          results.add(count); //단지마다 집 개수 결과에 저장
        }
      }
    }

    //결과..
    Collections.sort(results);
    System.out.println(results.size()); // 총 단지 수
    for(int houses:results){
      System.out.println(houses); //단지별 붙어있는 집의 수
    }
  }

  public static void DFS(int X,int Y){
    visited[X][Y] = true;
    count++;

    for(int i=0;i<4;i++){
      int nx = X + dx[i];
      int ny = Y + dy[i];
      //범위 안인지 if
      if(nx >=0 && ny >= 0 && nx < N && ny < N){
        //방문안했고, 집이 있는지.. if
        if(!visited[nx][ny] && map[nx][ny] == 1){
            DFS(nx, ny);
        }  
      }
    }
  }
}
