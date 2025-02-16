package DP;

import java.util.*;

public class JAVA_17070 {
    static int n;
    static int[][] map;
    static int result = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = sc.nextInt();
            }
        }
        
        // 시작 위치: (0,0)와 (0,1) 파이프의 한쪽 끝이 차지하고 있으므로
        if(map[0][1] == 0) {
            DFS(0, 1, 1);  // state 1: 가로
        }
        
        System.out.println(result);
    }
    
    // state: 1 = 가로, 2 = 세로, 3 = 대각선
    static void DFS(int y, int x, int state) {
        if(y == n - 1 && x == n - 1) {
            result++;
            return;
        }
        
        // 가로 상태일 때
        if(state == 1) {
            // 오른쪽 (가로)
            if(x + 1 < n && map[y][x+1] == 0) {
                DFS(y, x+1, 1);
            }
            // 대각선
            if(x + 1 < n && y + 1 < n 
               && map[y][x+1] == 0 && map[y+1][x] == 0 && map[y+1][x+1] == 0) {
                DFS(y+1, x+1, 3);
            }
        }
        // 세로 상태일 때
        else if(state == 2) {
            // 아래 (세로)
            if(y + 1 < n && map[y+1][x] == 0) {
                DFS(y+1, x, 2);
            }
            // 대각선
            if(x + 1 < n && y + 1 < n 
               && map[y][x+1] == 0 && map[y+1][x] == 0 && map[y+1][x+1] == 0) {
                DFS(y+1, x+1, 3);
            }
        }
        // 대각선 상태일 때
        else if(state == 3) {
            // 오른쪽 (가로)
            if(x + 1 < n && map[y][x+1] == 0) {
                DFS(y, x+1, 1);
            }
            // 아래 (세로)
            if(y + 1 < n && map[y+1][x] == 0) {
                DFS(y+1, x, 2);
            }
            // 대각선
            if(x + 1 < n && y + 1 < n 
               && map[y][x+1] == 0 && map[y+1][x] == 0 && map[y+1][x+1] == 0) {
                DFS(y+1, x+1, 3);
            }
        }
    }
}
