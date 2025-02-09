//요세푸스 순열 알고리즘
import java.util.*;

public class JAVA_1158 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();
    int index = 0; //지울 요소 인덱스값
    List<Integer> nums = new LinkedList<>();

    //리스트에 1~N까지 삽입
    for(int i = 0 ; i<N ; i++){
      nums.add(i+1);
    }

    //출력값 저장용 sb
    StringBuilder sb = new StringBuilder();
    sb.append("<");

    //리스트가 빌때까지 반복
    while(!nums.isEmpty()){
      index = (index + K - 1)%nums.size(); //삭제되는거 고려해서 -1 해줘야함
      sb.append(nums.get(index));
      nums.remove(index);
      if(nums.size()!=0) sb.append(", ");
    }
    sb.append(">");
    System.out.println(sb.toString());

    sc.close();
  }
}
