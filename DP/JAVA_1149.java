package DP;
//RGB 거리
import java.io.*;

public class JAVA_1149{
  public static int n;
  public static int[][] colorExp;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine()); // 집의 개수
    colorExp = new int[n][3]; // 각 집의 페인트 비용
    
    //비용 입력 받기
    for(int i = 0 ; i<n ; i++){
      String[] line = br.readLine().split(" ");
      colorExp[i][0] = Integer.parseInt(line[0]);
      colorExp[i][1] = Integer.parseInt(line[1]);
      colorExp[i][2] = Integer.parseInt(line[2]);
    }

    System.out.println(BottomUp(colorExp));

  }

  public static int BottomUp(int[][] colorExp){
    int[] color = {0,1,2,0,1}; //RGB 중복 방지

    for(int i = n-2 ; i >=0 ; i--){
      for(int j = 0 ; j < 3 ; j++){
        colorExp[i][j] += Math.min(colorExp[i+1][color[j+1]],colorExp[i+1][color[j+2]]);
      }
    }
    return Math.min(colorExp[0][0], Math.min(colorExp[0][1], colorExp[0][2]));
  }

}