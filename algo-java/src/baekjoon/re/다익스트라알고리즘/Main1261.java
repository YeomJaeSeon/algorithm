package baekjoon.re.다익스트라알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Algo implements Comparable<Algo>{
    private int x;
    private int y;
    private int count; // 벽 부순횟수..

    public Algo(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    @Override
    public int compareTo(Algo o) {
        return count - o.count;
    }
}

public class Main1261 {
    static int M, N;
    static int[][] graph;
    static int[][] d;
    static boolean[][] visited;
    static int INF = (int)1e9;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
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
            for(int j = 0; j < M; j++){
                graph[i][j] = s.charAt(j) == '0' ? 0 : 1;
                d[i][j] = INF;
            }
        }
        bfs();
        System.out.println(result);

    }
    static void bfs(){
        d[0][0] = 0;
        PriorityQueue<Algo> pq = new PriorityQueue<>();
        pq.offer(new Algo(0, 0, 0));

        while(!pq.isEmpty()){
            Algo poll = pq.poll();
            int x = poll.getX();
            int y = poll.getY();
            int count = poll.getCount();
            if(x == N - 1 && y == M - 1){
                result = count;
                break;
            }
            visited[x][y] = true;

            for(int i = 0; i < 4; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(visited[nextX][nextY]) continue;

                int cost = count + graph[nextX][nextY];
                if(cost < d[nextX][nextY]){
                    d[nextX][nextY] = cost;
                    pq.offer(new Algo(nextX, nextY, cost));
                }
            }
        }
    }

}

/**
 다익스트라알고리즘 : dp + greedy(우선순위 큐이용 - 선형적으로 최단경로찾는거보다 훨 시간이덜듬)

 **/