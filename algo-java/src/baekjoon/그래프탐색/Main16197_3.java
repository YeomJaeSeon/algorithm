package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main16197_3 {
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static List<Coin> coins = new ArrayList<>(); // 최초 코인의 위치
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int result = -100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                if(str.charAt(j) == 'o'){
                    board[i][j] = '.';
                    Coin coin = new Coin(i, j);
                    coins.add(coin);
                }else{
                    board[i][j] = str.charAt(j);
                }
            }
        }
        bfs(coins.get(0).x, coins.get(0).y, coins.get(1).x, coins.get(1).y);

        if(result == -100){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }
    static void bfs(int ax, int ay, int bx, int by){
        Queue<TwoCoins> q = new LinkedList<>();
        q.offer(new TwoCoins(ax, ay, bx, by, 0));
        visited[ax][ay][bx][by] = true;

        while(!q.isEmpty()){
            TwoCoins twoCoins = q.poll();
            //버튼 10번 이상 누른거면
            if(twoCoins.count >= 10) return;

            for(int i = 0; i < 4; i++){
                int nextAx = twoCoins.ax + dx[i];
                int nextAy = twoCoins.ay + dy[i];
                int nextBx = twoCoins.bx + dx[i];
                int nextBy = twoCoins.by + dy[i];

                //벽이 있다면
                if(!canMove(nextAx, nextAy)){
                    nextAx = twoCoins.ax;
                    nextAy = twoCoins.ay;
                }
                //벽이 있다면
                if(!canMove(nextBx, nextBy)){
                    nextBx = twoCoins.bx;
                    nextBy = twoCoins.by;
                }

                int fallCount = 0;
                if(nextAx < 0 || nextAx >= N || nextAy < 0 || nextAy >= M){
                    fallCount++;
                }
                if(nextBx < 0 || nextBx >= N || nextBy < 0 || nextBy >= M){
                    fallCount++;
                }

                if(fallCount == 1){
                    //하나만 떨어진다면
                    result = twoCoins.count + 1;
                    return;
                }else if(fallCount == 0){
                    //두개다 떨어지지않는다면
                    if(!visited[nextAx][nextAy][nextBx][nextBy]){
                        visited[nextAx][nextAy][nextBx][nextBy] = true;
                        q.offer(new TwoCoins(nextAx, nextAy, nextBx, nextBy, twoCoins.count + 1));
                    }
                }
            }
        }
    }
    static boolean canMove(int x, int y){
        if(x >= 0 && y >= 0 && x < N && y < M && board[x][y] == '#'){
            return false;
        }
        return true;
    }
}

class Coin{
    int x;
    int y;

    public Coin(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class TwoCoins{
    int ax;
    int ay;
    int bx;
    int by;
    int count;

    public TwoCoins(int ax, int ay, int bx, int by, int count) {
        this.ax = ax;
        this.ay = ay;
        this.bx = bx;
        this.by = by;
        this.count = count;
    }
}