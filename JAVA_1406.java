import java.io.*;

public class JAVA_1406 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder str = new StringBuilder(br.readLine());
    //실행할 명령어 개수
    int m = Integer.parseInt(br.readLine());
    int cursor = str.length();
    for(int i = 0 ; i < m ; i++){
      String command = br.readLine();
      char com = command.charAt(0);

      if(com == 'L'){
        if(cursor > 0) cursor--;
      } else if(com == 'D'){
        if(cursor< str.length()) cursor++;
      } else if(com == 'B'){
        if(cursor > 0){ str.deleteCharAt(cursor-1); cursor--; }
      } else if(com == 'P'){
        char x = command.charAt(2);
        str.insert(cursor,x);
        cursor++;
      }
    }
    System.out.println(str.toString());
  }
}
