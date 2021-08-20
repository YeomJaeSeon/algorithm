package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main16197 {
    static int N, M;
    static int[][] boardA;
    static boolean[][] visitedA;
    static int[][] boardB;
    static boolean[][] visitedB;
    static List<Integer> coinPos = new ArrayList<>(); // 현재 동전의 위치
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int min = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boardA = new int[N][M];
        boardB = new int[N][M];
        visitedA = new boolean[N][M];
        visitedB = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                if(str.charAt(j) == '.') {
                    boardA[i][j] = 0; //빈칸
                    boardB[i][j] = 0;
                }
                else if(str.charAt(j) == 'o') {
                    coinPos.add(i);
                    coinPos.add(j);
                }
                else {
                    boardA[i][j] = -1; //벽
                    boardB[i][j] = -1;
                }
            }
        }

        boardA[coinPos.get(0)][coinPos.get(1)] = 1; //동전
        boardB[coinPos.get(2)][coinPos.get(3)] = 1;

        bfs(coinPos.get(0), coinPos.get(1), coinPos.get(2), coinPos.get(3));


        if(min == 10000000)
            System.out.println(-1);
        else
            System.out.println(min);
    }
    static void bfs(int ax, int ay, int bx, int by){
        Queue<TwoCoin> q = new LinkedList<>();
        q.offer(new TwoCoin(ax, ay, bx, by));
        visitedA[ax][ay] = true;
        visitedB[bx][by] = true;

        while(!q.isEmpty()){
            TwoCoin coin = q.poll();
            int cax = coin.ax;
            int cay = coin.ay;
            int cbx = coin.bx;
            int cby = coin.by;
            if(boardB[cbx][cby] > 10 || boardA[cax][cay] > 10) {
                min = -1;
                return;
            }

            for(int i = 0; i < 4; i++){
                boolean isAOut = false;
                boolean isBOut = false;
                //동전 A
                int nextAx = cax + dx[i];
                int nextAy = cay + dy[i];

                //동전 B
                int nextBx = cbx + dx[i];
                int nextBy = cby + dy[i];

                if(nextAx < 0 || nextAx >= N || nextAy < 0 || nextAy >= M){
                    //A동전이 밖에나갈때
                    isAOut = true;
                }
                if(nextBx < 0 || nextBx >= N || nextBy < 0 || nextBy >= M){
                    //B동전이 밖에 나갈 때
                    isBOut = true;
                }
                if(isAOut && isBOut){
                    continue;
                } else if(isAOut && !isBOut){
                    min = Math.min(min, boardA[cax][cay]);
                    return;
                } else if(!isAOut && isBOut){
                    min = Math.min(min, boardB[cbx][cby]);
                    return;
                } else{
                    boolean isAWall = false;
                    boolean isBWall = false;
                    if(boardA[nextAx][nextAy] > 0 ) continue;
                    if(boardA[nextAx][nextAy] == -1) isAWall = true;
                    if(boardB[nextBx][nextBy] == -1) isBWall = true;
                    if(isAWall && isBWall) continue;
                    else if(isAWall && !isBWall){
                        boardB[nextBx][nextBy] = boardB[cbx][cby] + 1;
                        q.offer(new TwoCoin(cax, cay, nextBx, nextBy));
                    }else if(!isAWall && isBWall){
                        boardA[nextAx][nextAy] = boardA[cax][cay] + 1;
                        q.offer(new TwoCoin(nextAx, nextAy, cbx, cby));
                    }else{
                        boardA[nextAx][nextAy] = boardA[cax][cay] + 1;
                        boardB[nextBx][nextBy] = boardB[cbx][cby] + 1;
                        q.offer(new TwoCoin(nextAx, nextAy, nextBx, nextBy));
                    }
                }

                display();
            }
        }
    }
    static void display(){
        System.out.println("//==AA==//");
        for(int i = 0; i < N; i++){
            for(int j = 0 ;j < M; j++){
                System.out.print(boardA[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("//==BB==//");
        for(int i = 0; i < N; i++){
            for(int j = 0 ;j < M; j++){
                System.out.print(boardB[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
}


class TwoCoin{
    int ax;
    int ay;
    int bx;
    int by;

    TwoCoin(int ax, int ay, int bx, int by){
        this.ax = ax;
        this.ay = ay;
        this.bx = bx;
        this.by = by;
    }
}