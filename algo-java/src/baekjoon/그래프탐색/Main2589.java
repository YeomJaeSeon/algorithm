package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2589 {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                board[i][j] = str.charAt(j) == 'W' ? 0 : 1; //바다는 0 육지는 1
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                int[][] newBoard = init();
                max = Math.max(max, bfs(i, j, newBoard));
            }
        }
        System.out.println(max - 1);

    }
    static int bfs(int x, int y, int[][] board){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        int maxV = -1;
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] poll = q.poll();
            int c1 = poll[0];
            int c2 = poll[1];
            for(int i = 0; i < 4; i++){
                int nextX = c1 + dx[i];
                int nextY = c2 + dy[i];
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(board[nextX][nextY] == 0) continue;
                if(visited[nextX][nextY]) continue;
                q.offer(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
                board[nextX][nextY] = board[c1][c2] + 1;
                maxV = Math.max(maxV, board[nextX][nextY]);
            }
        }
        return maxV;
    }
    static int[][] init(){
        int[][] newBoard = new int[N][M];

        for (boolean[] booleans : visited) {
            Arrays.fill(booleans, false);
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                newBoard[i][j] = board[i][j];
            }
        }
        return newBoard;
    }
}
