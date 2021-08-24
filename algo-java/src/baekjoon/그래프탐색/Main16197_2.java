package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main16197_2 {
    static int N, M;
    static int[][] board1;
    static int[][] board2;
    static List<Integer> coinPos = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int min = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board1 = new int[N][M];
        board2 = new int[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                if(str.charAt(j) == '#'){ //벽
                    board1[i][j] = -1;
                    board2[i][j] = -1;
                }else{ //그외
                    board1[i][j] = 0;
                    board2[i][j] = 0;
                    if(str.charAt(j) == 'o'){
                        coinPos.add(i);
                        coinPos.add(j);
                    }
                }
            }
        }
        display();
        bfs(coinPos.get(0), coinPos.get(1), coinPos.get(2), coinPos.get(3));

        if(min == 10000000){
            System.out.println(-1);
        }else{
            System.out.println(min);
        }
    }
    static void bfs(int ax, int ay, int bx, int by){
        board1[ax][ay] = 1;
        board2[bx][by] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{ax, ay, bx, by});

        while(!q.isEmpty()){
            int[] poll = q.poll();
            int cax = poll[0];
            int cay = poll[1];
            int cbx = poll[2];
            int cby = poll[3];
            if(board1[cax][cay] > 10 || board2[cbx][cby] > 10) {
                min = -1;
                return;
            }

            for(int i = 0; i < 4; i++){
                display();
                int nextAx = cax + dx[i];
                int nextAy = cay + dy[i];
                int nextBx = cbx + dx[i];
                int nextBy = cby + dy[i];

                boolean aout = false;
                boolean bout = false;

                if(nextAx < 0 || nextAx >= N || nextAy < 0 || nextAy >= M){
                    aout = true;
                }
                if(nextBx < 0 || nextBx >= N || nextBy < 0 || nextBy >= M){
                    bout = true;
                }
                if(aout && bout){
                    //둘다 떨어짐
                    continue;
                }
                else if(!aout && !bout){
                    //둘다 안떨어짐
                    boolean isWallA = false;
                    boolean isWallB = false;

                    if(board1[nextAx][nextAy] == -1 || board1[nextAx][nextAy] > 0) isWallA = true;
                    if(board2[nextBx][nextBy] == -1 || board2[nextBx][nextBy] > 0) isWallB = true;
                    if(isWallA && isWallB){
                        //둘다 벽을 만남
                      continue;
                    }else if(!isWallA && !isWallB){
                        //둘다 벽을 만나지 않음
                        board1[nextAx][nextAy] = board1[cax][cay] + 1;
                        board2[nextBx][nextBy] = board2[cbx][cby] + 1;

                        q.offer(new int[]{nextAx, nextAy, nextBx, nextBy});
                    }else{
                        //둘중 하나만 벽을 만남
                        if(isWallA){
                            board2[nextBx][nextBy] = board2[cbx][cby] + 1;
                            q.offer(new int[]{cax, cay, nextBx, nextBy});
                        }else{
                            board1[nextAx][nextAy] = board1[cax][cay] + 1;
                            q.offer(new int[]{nextAx, nextAy, cbx, cby});
                        }
                    }

                }else{
                    //둘중 하나만 떨어짐
                    if(aout){
                        System.out.println("aout : " + board2[nextBx][nextBy]);
                    }else{
                        System.out.println("bout : " + board1[nextAx][nextAy]);
                    }
                    display();

//                    System.out.println("cax = " + cax);
//                    System.out.println("cay = " + cay);
//                    System.out.println("cbx = " + cbx);
//                    System.out.println("cby = " + cby);
//                    System.out.println("board1[cax][cay] = " + board1[cax][cay]);
//                    System.out.println("board2[cax][cay] = " + board2[cbx][cby]);
////                    min = Math.min(board1[cax][cay], board2[cax][cay]);
////                    min = Math.min(min, board1[cax][cay]);
                    return;
                }
            }
        }
    }
    static void display(){
        System.out.println();
        System.out.println("====board A========");
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(board1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("======board B =====");
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(board2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
