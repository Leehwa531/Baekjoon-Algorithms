import java.io.*;
import java.util.*;

public class JAVA_2903{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    System.out.println((int)(Math.pow(1+Math.pow(2, N),2))); //공식은 1+2의 N승
  }
}