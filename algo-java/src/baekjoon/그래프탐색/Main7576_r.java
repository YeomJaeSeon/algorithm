package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main7576_r {
    static int M, N;
    static int[][] board;
    static List<int[]> startPoints = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                int status = Integer.parseInt(st.nextToken());
                if(status == 1){
                    startPoints.add(new int[]{i, j});
                }
                board[i][j] = status;
            }
        }

        bfs();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                max = Math.max(max, board[i][j]);
                if(board[i][j] == 0){
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }

        System.out.println(--max);
    }
    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        for (int[] startPoint : startPoints) {
            q.offer(startPoint);
        }

        while(!q.isEmpty()){
            int[] poll = q.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            for(int i = 0; i < 4; i++){
                int nextX = dx[i] + currentX;
                int nextY = dy[i] + currentY;

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(board[nextX][nextY] != 0) continue;

                board[nextX][nextY] = board[currentX][currentY] + 1;
                q.offer(new int[]{nextX, nextY});
            }
        }
    }
}
