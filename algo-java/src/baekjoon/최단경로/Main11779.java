package baekjoon.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class DownTown implements Comparable<DownTown>{
    private int index;
    private int distance;

    public DownTown(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(DownTown o) {
        return distance - o.distance;
    }

    @Override
    public String toString() {
        return String.format("%d : %d%n", index, distance);
    }
}
public class Main11779 {
    static int N, M, start, end; // 도시개수, 버스수, 시작도시, 출발도시
    static List<List<DownTown>> graph = new ArrayList<>();
    static int[] d;
    static int[] nextHop;
    static boolean[] visited;
    static final int INF = (int)1e9;
    static List<DownTown> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        d = new int[N + 1];
        nextHop = new int[N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < M + 1; i++) graph.add(new ArrayList<>());

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph.get(s).add(new DownTown(e, dist));
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        Arrays.fill(d, INF);

        dijkstra();
        System.out.println(d[end]);
        System.out.println(result);

    }
    static void dijkstra(){
        d[start] = 0;
        PriorityQueue<DownTown> pq = new PriorityQueue<>();
        pq.offer(new DownTown(start, 0));

        while(!pq.isEmpty()){
            DownTown poll = pq.poll();
            int now = poll.getIndex();
            int dist = poll.getDistance();
            if(now == start){
                result = new ArrayList<>(); // 초기화
            }
            result.add(new DownTown(now, dist));

            if(visited[now]) continue;
            if(now == end) break;
            visited[now] = true;

            for (DownTown downTown : graph.get(now)) {
                int cost = downTown.getDistance() + dist;
                if(d[downTown.getIndex()] > cost){
                    d[downTown.getIndex()] = cost;
                    pq.offer(new DownTown(downTown.getIndex(), cost));
                }
            }
        }
    }
}
