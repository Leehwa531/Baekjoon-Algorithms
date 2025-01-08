import java.util.Scanner;

public class JAVA_2562 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] array = new int[9];
    for(int i = 0 ; i < array.length ; i++){
      array[i] = sc.nextInt();
    }
    int count = 0;
    int max = 0;
    int index = 0;
    for(int value : array){
      count++;

      if(value > max){
        max = value;
        index = count;
      }
    }
    System.out.println(max + "\n" + index);

    sc.close();
  }
}
