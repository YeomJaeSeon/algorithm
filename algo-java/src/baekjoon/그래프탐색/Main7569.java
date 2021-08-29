package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main7569 {
    static int M, N, H;
    static int[][][] board;
    static boolean[][][] visited;
    static List<Tomato> okTomatoes = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int max = -100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        board = new int[N][M][H];
        visited = new boolean[N][M][H];
        for(int h = 0; h < H; h++){
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < M; j++){
                    int v = Integer.parseInt(st.nextToken());
                    board[i][j][h] = v;
                    if(v == 1){
                        okTomatoes.add(new Tomato(i, j, h));
                    }
                }
            }
        }

        bfs();

        boolean isFull = true;
        for(int h = 0; h < H; h++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    max = Math.max(board[i][j][h], max);
                    if(board[i][j][h] == 0) {
                        isFull = false;
                        break;
                    }
                }
            }
        }
        if(isFull){
            System.out.println(max - 1);
        }else{
            System.out.println(-1);
        }
    }
    static void bfs(){
        Queue<Tomato> q = new LinkedList<>();
        okTomatoes.stream().forEach(q::offer);

        while(!q.isEmpty()){
            Tomato current = q.poll();
            for(int i = 0; i < 6; i++){
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];
                int nextZ = current.z + dz[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || nextZ < 0 || nextZ >= H) continue;
                if(board[nextX][nextY][nextZ] == 0){
                    board[nextX][nextY][nextZ] = board[current.x][current.y][current.z] + 1;
                    q.offer(new Tomato(nextX, nextY, nextZ));
                }
            }
        }
    }
}
class Tomato{
    int x;
    int y;
    int z;

    public Tomato(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}