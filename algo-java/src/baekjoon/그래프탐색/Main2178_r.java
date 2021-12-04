package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//가중치없는 그래프의 최단거리 - bfs
public class Main2178_r {
    static int N, M;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                board[i][j] = str.charAt(j) == '0' ? 1 : 0; //갈수있는곳은 0으로 바꿈
            }
        }

        System.out.println(bfs());
    }
    static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        board[0][0] = 1;

        while(!q.isEmpty()){
            int[] poll = q.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            if(currentX == N - 1 && currentY == M - 1)
                return board[currentX][currentY];

            for(int i = 0; i < 4; i++){
                int nextX = dx[i] + currentX;
                int nextY = dy[i] + currentY;
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(board[nextX][nextY] != 0) continue;

                board[nextX][nextY] = board[currentX][currentY] + 1;
                q.offer(new int[]{nextX, nextY});
            }
        }

        // 사실 입력에 이런경우는 없다고 했음
        return -1;
    }
}
