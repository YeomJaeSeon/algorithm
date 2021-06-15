package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1600 {
    static int K, W, H;
    static int[][] board;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};

    static int hx[] = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int hy[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    // 말의이동
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        board = new int[H][W];

        for(int i = 0; i < H; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < W; j++){
                board[i][j] = st2.nextToken().equals("0") ? 0 : -1;
            }
        }

        bfs(0, 0);

        int result = board[H - 1][W - 1];
        if(result > 0){
            System.out.println(--result);
        }else{
            System.out.println(-1);
        }

    }
    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        board[x][y] = 1;

        outer:
        while(!q.isEmpty()){
            int[] poll = q.poll();
            int cx = poll[0];
            int cy = poll[1];
            if(K > 0){
                for(int i = 0; i < 8; i++){
                    int nextX = cx + hx[i];
                    int nextY = cy + hy[i];

                    if(nextX < 0 || nextX >= H || nextY < 0 || nextY >= W) continue;
                    if(board[nextX][nextY] != 0) continue;

                    board[nextX][nextY] = board[cx][cy] + 1;
                    q.offer(new int[]{nextX, nextY});
                    K--;
                    if(K == 0) break;
                }
            }

            for(int i = 0; i < 4; i++){
                int nextX = cx + dx[i];
                int nextY = cy + dy[i];

                if(nextX < 0 || nextX >= H || nextY < 0 || nextY >= W) continue;
                if(board[nextX][nextY] != 0) continue;
                board[nextX][nextY] = board[cx][cy] + 1;

                q.offer(new int[]{nextX, nextY});
            }

        }
    }
}
