import java.util.*;

public class JAVA_10845 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    Queue<Integer> queue = new LinkedList<>();
    int num = 0;

    for (int i = 0; i < N; i++) {
      String command = sc.next();
      switch (command) {
        case "push":
          num = sc.nextInt();
          queue.add(num);
          break;
        case "pop":
          if (queue.isEmpty()) {
            System.out.println(-1);
          } else {
            System.out.println(queue.poll());
          }
          break;
        case "size":
          System.out.println(queue.size());
          break;
        case "empty":
          System.out.println(queue.isEmpty() ? 1 : 0);
          break;
        case "front":
          System.out.println(queue.isEmpty() ? -1 : queue.peek());
          break;
        case "back":
          System.out.println(queue.isEmpty() ? -1 : ((LinkedList<Integer>) queue).getLast());
          break;
        default:
          break;
      }
    }
    sc.close();
  }
}
