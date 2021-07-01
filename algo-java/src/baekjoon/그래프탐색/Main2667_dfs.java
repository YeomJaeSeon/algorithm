package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2667_dfs {
    static List<Integer> list = new ArrayList<>();
    static int N;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                board[i][j] = str.charAt(i) == '0' ? 0 : 1;
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                dfs(i, j, 0);
            }
        }

    }
    static int dfs(int x, int y, int count){
        if(board[x][y] == 0) return count;

        for(int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(board[nextX][nextY] != 0){
                board[nextX][nextY] = 0; // 방문처리
                dfs(nextX, nextY, count + 1);
            }
        }
    }
}
