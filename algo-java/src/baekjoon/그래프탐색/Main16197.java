package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main16197 {
    static int N, M;
    static int[][] board;
    static List<Integer> coinPos = new ArrayList<>(); //동전의 위치
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                if(str.charAt(j) == '.') board[i][j] = 0; //빈칸
                else if(str.charAt(j) == 'o') {
                    board[i][j] = 1; //동전
                    coinPos.add(i);
                    coinPos.add(j);
                }
                else board[i][j] = -1; //벽
            }
        }

        bfs(coinPos.get(0), coinPos.get(1), coinPos.get(2), coinPos.get(3), 0);

        if(max > 10)
            System.out.println(-1);
        else System.out.println(max);
    }
    static void bfs(int ax, int ay, int bx, int by, int count){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{ax, ay});
        board[ax][ay] = -2;
        q.offer(new int[]{bx, by});
        board[bx][by] = -3;

        while(!q.isEmpty()){
            int[] poll = q.poll();
            int cax = poll[0];
            int cay = poll[1];

            int[] poll1 = q.poll();
            int cbx = poll1[0];
            int cby = poll1[1];

            for(int i = 0; i < 4; i++){
                boolean one = false;
                boolean two = false;
                int jumCnt = 0;
                int nextAx = cax + dx[i];
                int nextAy = cay + dy[i];
                int nextBx = cbx + dx[i];
                int nextBy = cby + dy[i];
                if(nextAx < 0 || nextAx >= N || nextAy < 0 || nextAy >= M) {
                    jumCnt++;
                    one = true;
                }
                if(nextBx < 0 || nextBx >= N || nextBy < 0 || nextBy >= M) {
                    jumCnt++;
                    two = true;
                }
                if(jumCnt == 1){
                    max = Math.max(max, count);
                }
                if(!one && board[nextAx][nextAy] != -1 && board[nextAx][nextAy] != -2) {
                    q.offer(new int[]{nextAx, nextAy});
                    board[nextAx][nextAy] = -2;
                }
                if(!two && board[nextBx][nextBy] != -1 && board[nextBx][nextBy] != -3) {
                    q.offer(new int[]{nextBx, nextBy});
                    board[nextBx][nextBy] = -3;
                }
            }
        }
    }
}
