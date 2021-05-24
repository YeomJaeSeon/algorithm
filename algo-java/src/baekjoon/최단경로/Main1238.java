package baekjoon.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Town implements Comparable<Town>{
    private int index;
    private int distance;

    public Town(int index, int distance){
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
    public int compareTo(Town o) {
        return distance - o.distance;
    }
}

public class Main1238 {
    static int V, E, end;
    static List<List<Town>> graph = new ArrayList<>();
    static int[] d;
    static int max = 0;
    static boolean[] visited;
    static int INF = (int)1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        for(int i = 0; i < V + 1; i++) graph.add(new ArrayList<>());
        for(int i = 0; i < E; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());
            graph.get(a).add(new Town(b, c));
        }
        visited = new boolean[V + 1];
        d = new int[V + 1];

        for(int i = 1; i <= V; i++){
            Arrays.fill(visited, false);
            Arrays.fill(d, INF);
            dijkstra(i);
            int go = d[end];

            Arrays.fill(visited, false);
            Arrays.fill(d, INF);
            dijkstra(end);
            int come = d[i];

            max = Math.max(max, go + come);
        }
        System.out.println(max);

    }
    static void dijkstra(int start){
        PriorityQueue<Town> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.offer(new Town(start, 0));

        while(!pq.isEmpty()){
            Town town = pq.poll();
            int now = town.getIndex();
            int dist = town.getDistance();
            if(visited[now]) {
                continue;
            }
            visited[now] = true;

            for (Town town1 : graph.get(now)) {
                int cost = dist + town1.getDistance();
                if(d[town1.getIndex()] > cost){
                    d[town1.getIndex()] = cost;
                    pq.offer(new Town(town1.getIndex(), cost));
                }
            }
        }
    }
}

/**
 최단경로 - 다익스트라 알고리즘 (greedy + dp)
 왔다 가는데 최단경로이므로 다익스트라 알고리즘 두번적용해야함
 처음엔 기존의 dp테이블을 재사용해야하나 생각했는데그게아니라 갈때, 올때는 각각 다른 경로로로
 각각의 최단경로를 더하는게 적절함
 **/