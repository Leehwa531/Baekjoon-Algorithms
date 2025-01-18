import java.util.*;

public class JAVA_4153 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<Integer> line;

  
    while(true){
      line = new ArrayList<>();
      for(int i = 0 ; i<3;i++){
        line.add(sc.nextInt());
      }
      if(line.get(0)==0&&line.get(1)==0&&line.get(2)==0){
        break;
      }
      Collections.sort(line);
      if (Math.pow(line.get(0), 2) + Math.pow(line.get(1), 2) == Math.pow(line.get(2),2)){
        System.out.println("right");
      }
      else{
        System.out.println("wrong");
      }
    }
  }
}