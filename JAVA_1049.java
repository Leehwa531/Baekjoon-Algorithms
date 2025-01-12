import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JAVA_1049 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    // int[] packagePrice = new int[M];
    // int[] onePrice = new int[M];
    int lowPackagePrice = 0;
    int lowOnePrice = 0;
    int currentPackagePrice = 0;
    int currentOnePrice = 0;

    for(int i =0;i<M;i++){
      st = new StringTokenizer(br.readLine());
      currentPackagePrice = Integer.parseInt(st.nextToken());
      currentOnePrice = Integer.parseInt(st.nextToken());
      if (i ==0){
        lowPackagePrice = currentPackagePrice;
        lowOnePrice = currentOnePrice;
      }
      if(lowPackagePrice>currentPackagePrice){
        lowPackagePrice = currentPackagePrice;
      }
      if(lowOnePrice>currentOnePrice){
        lowOnePrice=currentOnePrice;
      }
      // packagePrice[i] = Integer.parseInt(st.nextToken());
      // onePrice[i] = Integer.parseInt(st.nextToken());
    }
    int buyPackage = N/6;
    int another = N%6;
    
    // 세 가지 경우의 가격을 비교
    int case1 = (buyPackage + 1) * lowPackagePrice;  // 패키지로만 구매
    int case2 = N * lowOnePrice;  // 낱개로만 구매
    int case3 = (buyPackage * lowPackagePrice) + (another * lowOnePrice);  // 조합
    
    int total = Math.min(case1, Math.min(case2, case3));
    System.out.println(total);

    // 3가지 경우를 추가
    // 패키지만 샀을때,
    // 낱개로만 샀을때,
    // 패캐지 + 낱개일때
  }
}
