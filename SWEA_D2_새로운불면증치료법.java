import java.util.Scanner;

public class SWEA_D2_새로운불면증치료법 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    int one = 0;
    int k = 1;
    boolean[] oneToNine = new boolean[10];
    //T만큼 반복해서 실행
    for(int i = 0 ; i < T ; i++){
      int N = sc.nextInt();

      while(true){
      
      while(N>=10){
        one /=10;
        one = (N*k) % 10;
        oneToNine[one] = true;
        }
        
      }
      k++;
    }
      




    }
  }
}
