package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2206_re {
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
        board = new int[N][M];
        visited = new boolean[N][M][2];// 벽을 부순 상태의 방문처리, 부수지 않은 상태의 방문처리 각각해야한다.

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                if(str.charAt(j) == '0'){
                    board[i][j] = 0;
                }else{
                    board[i][j] = 1;
                }
            }
        }

        bfs();
        System.out.println(result);

    }
    static void bfs(){
        Queue<Man> q = new LinkedList<>();
        q.offer(new Man(0, 0, 0, false));
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            Man current = q.poll();
            if(current.x == N - 1 && current.y == M - 1){
                result = current.count + 1;
                return;
            }
            for(int i = 0; i < 4; i++){
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(board[nextX][nextY] == 1){
                    //벽
                    if(visited[nextX][nextY][1]) continue;
                    if(current.isBroke) continue;
                    else{
                        visited[nextX][nextY][1] = true;
                        q.offer(new Man(nextX, nextY, current.count + 1, true));
                    }
                }else{
                    //벽 x
                    if(current.isBroke){
                        //벽을 부순상태라면
                        if(visited[nextX][nextY][1]) continue;
                        else{
                            visited[nextX][nextY][1] = true;
                            q.offer(new Man(nextX, nextY, current.count + 1, current.isBroke));
                        }
                    }else{
                        //벽을 부순상태가 아니라면
                        if(visited[nextX][nextY][0]) continue;
                        else{
                            visited[nextX][nextY][0] = true;
                            q.offer(new Man(nextX, nextY, current.count + 1, current.isBroke));
                        }
                    }

                }
            }
        }
    }
}
class Man{
    int x;
    int y;
    int count;
    boolean isBroke;

    Man(int x, int y, int count, boolean isBroke) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.isBroke = isBroke;
    }
}