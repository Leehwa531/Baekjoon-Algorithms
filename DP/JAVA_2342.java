package DP;
import java.io.*;
import java.util.*;

public class JAVA_2342 {
  static List<Integer> steps = new ArrayList<>();
  static int[][][] dp;

  //A -> B로 가는 발의 비용
  //cost[i][j] -> i에서 j로 이동하는데 드는 비용
  static int[][] cost = {
    { 0, 2, 2, 2, 2},
    { 0, 1, 3, 4, 3},
    { 0, 3, 1, 3, 4},
    { 0, 4, 3, 1, 3},
    { 0, 3, 4, 3, 1}
  };

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    String line = br.readLine();
    StringTokenizer st = new StringTokenizer(line);

    while(true){
      int num = Integer.parseInt(st.nextToken());
      if(num == 0) break;
      steps.add(num);
    }

    //최소 비용 저장용 배열 dp
    dp = new int[5][5][steps.size()];
    
    int result = doDance(0,0,0);
    
    System.out.print(result);
    
  }

  public static int doDance(int leftFoot,int rightFoot,int step){
    //발판을 모두 밟으면 종료
    if (step == steps.size()) return 0;

    //이미 밟았으면 "바로 그냥 리턴"
    if(dp[leftFoot][rightFoot][step] != 0) return dp[leftFoot][rightFoot][step];

    int nextStep = steps.get(step);
    
    //더 낮은 비용을 저장
    dp[leftFoot][rightFoot][step] = Math.min(doDance(nextStep, rightFoot, step+1) + cost[leftFoot][nextStep],   //왼발을 움직일 때
                                             doDance(leftFoot, nextStep, step+1) + cost[rightFoot][nextStep]);  //오른발을 움직일 때
    return dp[leftFoot][rightFoot][step];
  }
}
