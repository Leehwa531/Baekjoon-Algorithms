import java.io.*;

public class JAVA_21734 {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    String word = br.readLine();

    for(int i =0 ; i<word.length();i++){
      int one = word.charAt(i);
      int sum = 0;
      sum += one / 100;
      sum += (one/10)%10;
      sum += one %10;
      for(int j = 0 ; j<sum;j++){
        System.out.print(word.charAt(i));
      }
      System.out.println();
    }
  }
}
