import java.util.Scanner;

public class JAVA_10828 {
    public static int[] stack;
    public static int size = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int N = in.nextInt();
        stack = new int[N];
        
        for (int i = 0; i < N; i++) {
            String str = in.next();

            switch (str) {
                case "push":
                    push(in.nextInt());
                    break;
                
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                
                case "size":
                    sb.append(size()).append('\n');
                    break;
                
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                
                case "top":
                    sb.append(top()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void push(int item) {
        stack[size] = item;
        size++;
    }
    
    public static int pop() {
        if (size == 0) {
            return -1;
        } else {
            int res = stack[size - 1];
            stack[size - 1] = 0;
            size--;
            return res;
        }
    }
    
    public static int size() {
        return size;
    }
    
    public static int empty() {
        return size == 0 ? 1 : 0;
    }
    
    public static int top() {
        return size == 0 ? -1 : stack[size - 1];
    }
}