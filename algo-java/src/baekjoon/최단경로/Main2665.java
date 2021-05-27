package baekjoon.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Room implements Comparable<Room>{
    private int x;
    private int y;
    private int count; // 벽 바꾼횟수

    public Room(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCount() {
        return count;
    }

    @Override
    public int compareTo(Room o) {
        return count - o.count;
    }
}

public class Main2665 {
    static int N;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] d;
    static int INF = (int)1e9;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];
        d = new int[N][N];
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < N; j++){
                graph[i][j] = Integer.parseInt(s.charAt(j)+"");
            }
        }

        for (int[] ints : d) {
            Arrays.fill(ints, INF);
        }

        dijkstra();

        System.out.println(d[N-1][N-1]);
    }
    static void dijkstra(){
        d[0][0] = 0;
        PriorityQueue<Room> pq = new PriorityQueue<>();
        pq.offer(new Room(0, 0, 0));

        while(!pq.isEmpty()){
            Room poll = pq.poll();
            int x = poll.getX();
            int y = poll.getY();
            int dist = poll.getCount();
            if(visited[x][y]) continue;
            visited[x][y] = true;
            for(int i = 0; i < 4; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                if(visited[nextX][nextY]) continue;

                if(graph[nextX][nextY] == 0){
                    int cost = dist + 1;
                    if(cost < d[nextX][nextY]){
                        d[nextX][nextY] = cost;
                        pq.offer(new Room(nextX, nextY, cost));
                    }
                }else{
                    if(dist < d[nextX][nextY]) {
                        d[nextX][nextY] = dist;
                        pq.offer(new Room(nextX, nextY, dist));
                    }
                }
            }
        }
    }
}

/**
 풀이
 일단 0 0 -> N -1, N - 1로가는데 검은방 만날 최소횟수를 구하는 거임.
 최단경로 문제라는걸 꺠달음 BFS에서 큐를 사용한대신 우선순위큐를 사용하자.
 그리디알고리즘 : 우선순위큐이용으로 구현 - 현재노드에서 가장 가까운 노드를꺼내는건 우선순위큐를 통해서
 dp : 메모이제이션을 통해서 최단거리 갱신해나감

 **/