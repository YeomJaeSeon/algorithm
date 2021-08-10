package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1987 {
    static int R, C;
    static int[][] board;
    static boolean[] visited = new boolean[26];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j = 0; j < C; j++){
                board[i][j] = str.charAt(j) - 65;
            }
        }
        dfs(0, 0, 0);

        System.out.println(max + 1);

    }
    static void dfs(int x, int y, int count){
        visited[board[x][y]] = true;
        max = Math.max(max, count);
        for(int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) continue;
            if(visited[board[nextX][nextY]]) continue;

            dfs(nextX, nextY, count + 1);
        }
        visited[board[x][y]] = false;
    }
}
