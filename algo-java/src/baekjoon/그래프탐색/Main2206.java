package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2206 {
    static int N, M;
    static int[][] board;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M][2];
        board = new int[N][M];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                if(str.charAt(j) == '0'){
                    board[i][j] = 0;
                }else{
                    board[i][j] = -1;
                }
            }
        }

        bfs();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println(result);

    }
    static void bfs(){
        Queue<Person> q = new LinkedList<>();
        q.offer(new Person(0, 0, 0));
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            Person current = q.poll();
            System.out.println("current = " + current.count);
            if(current.x == N - 1 && current.y == M - 1) {
                result = current.count;
                return;
            }
            for(int i = 0; i < 4; i++){
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(board[nextX][nextY] == -1 && visited[nextX][nextY][1]) continue;
                if(board[nextX][nextY] == -1 && !visited[nextX][nextY][1]){
                    q.offer(new Person(nextX, nextY, current.count + 1));
                    visited[nextX][nextY][1] = true;
                    continue;
                }
                if(board[nextX][nextY] == 0 && !visited[nextX][nextY][0]){
                    q.offer(new Person(nextX, nextY, current.count + 1));
                    visited[nextX][nextY][0] = true;
                    continue;
                }

            }
        }

    }
}
class Person{
    int x;
    int y;
    int count;

    public Person(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}