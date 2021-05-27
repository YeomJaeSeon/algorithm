package baekjoon.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Loopy implements Comparable<Loopy>{
    private int x;
    private int y;
    private int distance;
    public Loopy(int x, int y, int distance){
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Loopy o) {
        return distance - o.distance;
    }
}

public class Main4485 {
    static int N;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] d;
    static int INF = (int)1e9;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 1;

        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0) break; // 종료조건

            graph = new int[N][N];
            visited = new boolean[N][N];
            d = new int[N][N];

            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " " );
                for(int j = 0; j < N; j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int[] ints : d) {
                Arrays.fill(ints, INF);
            }

            dijkstra();

            System.out.printf("Problem %d: %d%n", idx++, d[N - 1][N - 1]);
        }
    }
    static void dijkstra(){
        d[0][0] = graph[0][0]; // 자기까지의 경로비용 0
        PriorityQueue<Loopy> pq = new PriorityQueue<>();
        pq.offer(new Loopy(0, 0, graph[0][0]));

        while(!pq.isEmpty()){
            Loopy poll = pq.poll();
            int x = poll.getX();
            int y = poll.getY();
            int dist = poll.getDistance();

            if(visited[x][y]) continue;

            visited[x][y] = true; // PQ에서꺼낸거는 현재에서 가장가까운 최단경로를 선택한것이므로

            for(int i = 0; i < 4; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                if(visited[nextX][nextY]) continue;
                int cost = dist + graph[nextX][nextY];
                if(cost < d[nextX][nextY]){
                    d[nextX][nextY] = cost;
                    pq.offer(new Loopy(nextX, nextY, cost));
                }
            }

        }
    }
}
