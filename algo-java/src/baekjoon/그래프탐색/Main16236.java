package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16236 {
    static int N;
    static int[][] board;
    static int sharkX;
    static int sharkY;
    static int fishCount;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 9){
                    sharkX = i;
                    sharkY = j;
                }else if(num == 0){}
                else{
                    fishCount++;
                }
                board[i][j] = num;
            }
        }
        if(fishCount == 0){
            System.out.println(0);
        }else{
            System.out.println(bfs());
        }


    }
    static int bfs(){
        Queue<Shark> q = new LinkedList<>();
        q.offer(new Shark(sharkX, sharkY, 0, 0, 2));
        visited[sharkY][sharkY] = true;
        int totalMoveCount = 0;

        while(!q.isEmpty()){
            if(fishCount == 0) break;
            Shark current = q.poll();
            for(int i = 0; i < 4; i++){
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                if(board[nextX][nextY] > current.size) continue;
                if(!visited[nextX][nextY] && board[nextX][nextY] != 0 && board[nextX][nextY] < current.size){
                    //요기 고민좀해보자
                    q.clear();
                    fishCount--;
                    totalMoveCount += (current.moveCount + 1);
                    if(current.eatCount + 1 == current.size){
                        q.offer(new Shark(nextX, nextY, 0, 0, current.size + 1));
                    }else{
                        q.offer(new Shark(nextX, nextY, 0, current.eatCount + 1, current.size));
                    }
                    initVisited();
                    visited[nextX][nextY] = true;
                    continue;
                }
                if(!visited[nextX][nextY] && board[nextX][nextY] == 0){
                    q.offer(new Shark(nextX, nextY, current.moveCount + 1, current.eatCount, current.size));
                    visited[nextX][nextY] = true;
                    continue;
                }
            }
        }
        return totalMoveCount;
    }
    static void initVisited(){
        for (boolean[] booleans : visited) {
            Arrays.fill(booleans, false);
        }
    }
}
class Shark{
    int x;
    int y;
    int moveCount;
    int eatCount;
    int size;

    public Shark(int x, int y, int moveCount, int eatCount, int size) {
        this.x = x;
        this.y = y;
        this.moveCount = moveCount;
        this.eatCount = eatCount;
        this.size = size;
    }
}