package baekjoon.세그먼트트리재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10472 {
    static char[][] board = new char[][]{
            {'.', '.', '.'},
            {'.', '.', '.'},
            {'.', '.', '.'}
    };
    static int[][] visited = new int[3][3];
    static char[][] result;
    static int minCount = Integer.MAX_VALUE;
    static final int[] dx = {-1, 1, 0, 0, 0};
    static final int[] dy = {0, 0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        //test 시작
        for(int i = 0; i < P; i++){
            result = new char[3][3]; // 정답
            for(int j = 0; j < 3; j++){
                String s = br.readLine();
                result[j][0] = s.charAt(0);
                result[j][1] = s.charAt(1);
                result[j][2] = s.charAt(2);
            }
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){
                    solve(j, k, 1);
                    initialize();
                }
            }
            System.out.println(minCount);
            minCount = Integer.MAX_VALUE;
        }
    }

    public static void solve(int x, int y, int clickCount){
        if(x < 0 || x >= 3 || y < 0 || y >= 3)
            return;
        if(visited[x][y] == 2) return;
        visited[x][y]++;

        change(x, y);

        if(isSame()){
            minCount = Math.min(clickCount, minCount);
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                solve(i, j, clickCount++);
            }
        }

    }
    public static void change(int x, int y){
        for(int i = 0; i < 5; i++){
            if(x + dx[i] < 0 || x + dx[i] >= 3 || y + dy[i] < 0 || y + dy[i] >= 3) continue;
            board[x + dx[i]][y + dy[i]] = board[x + dx[i]][y + dy[i]] == '.' ? '*' : '.';
        }
    }
    public static void initialize(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                visited[i][j] = 0;
                board[i][j] = '.';
            }
        }
    }
    public static boolean isSame(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] != result[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
