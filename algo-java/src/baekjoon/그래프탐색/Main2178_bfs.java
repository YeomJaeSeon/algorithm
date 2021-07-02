package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2178_bfs {
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
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                board[i][j] = s.charAt(j) == '0' ? 0 : 1;
            }
        }
        bfs(0, 0);

        System.out.println(board[N - 1][M - 1] - 1);
    }
    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        board[y][x] = 2;

        while(!q.isEmpty()){
            int[] poll = q.poll();
            int cx = poll[0];
            int cy = poll[1];

            if(cx == M - 1 && cy == N - 1) break;

            for(int i = 0; i < 4; i++){
                int nextX = cx + dx[i];
                int nextY = cy + dy[i];
                if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) continue;
                if(board[nextY][nextX] != 1) continue;
                q.offer(new int[]{nextX, nextY});
                board[nextY][nextX] = board[cy][cx] + 1; // 방문
            }
        }
    }
}

/**
 최소거리를 찾는당.
 bfs를 이용한다.
 이전에서온 거리 + 1로 올때까지의 타일의 개수를 저장한다.
  끄읏

 **/