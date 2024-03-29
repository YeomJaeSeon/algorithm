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

        System.out.println(result);
    }
    static void bfs(){
        Queue<Person> q = new LinkedList<>();
        q.offer(new Person(0, 0, 0, false));
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            Person current = q.poll();
            if(current.x == N - 1 && current.y == M - 1) {
                result = current.count + 1;
                return;
            }
            for(int i = 0; i < 4; i++){
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(board[nextX][nextY] == -1){
                    //가려는 곳이 벽이면
                    if(visited[nextX][nextY][1]) continue; //방문했다면
                    if(current.isBroke)continue;
                    //가려는 곳이 벽인데 부순적이 있다면
                    else{
                        //가려는 곳이 벽인데 부순적이 없다면
                        visited[nextX][nextY][1] = true;
                        q.offer(new Person(nextX, nextY, current.count + 1, true));
                    }
                }else{
                    //가려는 곳이 벽이아니면
                    if(current.isBroke){
                        //벽을 부순적이있으면
                        if(visited[nextX][nextY][1]) continue;
                        else{
                            visited[nextX][nextY][1] = true;
                            q.offer(new Person(nextX, nextY, current.count + 1, current.isBroke));
                        }
                    }else{
                        //벽을 부순적이 없으면
                        if(visited[nextX][nextY][0]) continue;
                        else{
                            visited[nextX][nextY][0] = true;
                            q.offer(new Person(nextX, nextY, current.count + 1, current.isBroke));
                        }
                    }
                }
            }
        }

    }
}
class Person{
    int x;
    int y;
    int count;
    boolean isBroke;

    public Person(int x, int y, int count, boolean isBroke) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.isBroke = isBroke;
    }

    @Override
    public String toString() {
        return "Person{" +
                "x=" + x +
                ", y=" + y +
                ", count=" + count +
                ", isBroke=" + isBroke +
                '}';
    }
}