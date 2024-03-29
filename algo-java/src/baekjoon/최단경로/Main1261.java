package baekjoon.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Algo implements Comparable<Algo>{
    private int count;
    private int x;
    private int y;

    public Algo(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Algo o) {
        return count - o.count;
    }
}

public class Main1261 {
    static int M;
    static int N;
    static int[][] graph;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] d; // dp테이블을 통해서 최단경로 ..메모
    static int INF = (int)1e9;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        d = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                graph[i][j] = s.charAt(j) == '0' ? 0 : 1;
                d[i][j] = INF;
            }
        }
        bfs();
        System.out.println(result);
    }
    static void bfs(){
        PriorityQueue<Algo> pq = new PriorityQueue<>();
        visited[0][0] = true;
        pq.offer(new Algo(0, 0, 0));
        d[0][0] = 0;

        while (!pq.isEmpty()){
            Algo algo = pq.poll(); // 우선순위 큐에서 꺼내지는 녀석은 해당 위치에서 벽을 부술수있는 최소의 경로임. 그러므로 이 경로는 방문처리를 해야함. 다시는 재방문하지않도록.
            int x = algo.getX();
            int y = algo.getY();
            visited[x][y] = true; // 우선순위 큐에서 꺼낸녀석은 벽을 부순 최소 경로이므로 거긴 방문처리.. - 이를통해 큐에 너무많은 데이터소스가 쌓이는걸 막음 - 메모리초과해결
            int count = algo.getCount();
            if(x == N - 1 && y == M - 1) {
                result = count;
                break;
            }
            int nextX = 0;
            int nextY = 0;
            for(int i = 0; i < 4; i++){
                nextX = x + dx[i];
                nextY = y + dy[i];
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M){
                    continue;
                }
                if(visited[nextX][nextY]) continue;
                int cost = count + graph[nextX][nextY];
                if(d[nextX][nextY] > cost){
                    d[nextX][nextY] = cost;
                    pq.offer(new Algo(nextX, nextY, cost));
                }
            }
        }
    }
}
