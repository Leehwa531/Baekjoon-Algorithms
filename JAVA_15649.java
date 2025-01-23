import java.util.Scanner;

public class JAVA_15649 {
  static boolean[] isUsed;
  static int[] pickedNumbers;
  static int N,M;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    M = sc.nextInt();

    isUsed = new boolean[N+1];
    pickedNumbers = new int[M];

    DFS(0);
  
    sc.close();
  }

  public static void DFS(int depth){

    if(depth == M){
      for(int num : pickedNumbers){
        System.out.print(num+" ");
      }
      System.out.println();
      return;
    }

    for(int i = 1 ; i <=N ; i++){
      if(isUsed[i]==false){
        pickedNumbers[depth] = i;
        isUsed[i] = true;
        DFS(depth +1);
        isUsed[i] = false;
      }
    }
  }
}
