package baekjoon.re.다익스트라알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class City implements Comparable<City>{
    private int index;
    private int distance;

    public City(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }


    @Override
    public int compareTo(City o) {
        return this.distance - o.distance;
    }
}

public class Main1916 {
    static List<List<City>> graph = new ArrayList<>();
    static int[] d;
    static int N;
    static int M;
    static int INF = (int)1e9;
    static int start, end;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 도시의 개수
        M = Integer.parseInt(br.readLine()); // 간선의 개수

        d = new int[N + 1];
        visited = new boolean[N + 1];
        for(int i = 0; i < N + 1; i++) graph.add(new ArrayList<>());

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int city1 = Integer.parseInt(st.nextToken());
            int city2 = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph.get(city1).add(new City(city2, dist));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        Arrays.fill(d, INF);
        dijkstra(start);

        System.out.println(d[end]);
    }
    static void dijkstra(int start){
        d[start] = 0;
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.offer(new City(start, 0));
        visited[start] = true;

        while(!pq.isEmpty()){
            City city = pq.poll();
            int now = city.getIndex();
            int dist = city.getDistance();
            if(visited[now] && now != start) {
                if(now == end) break;
                continue;
            }
            visited[now] = true;// 우선순위 큐에서 꺼낸녀석은 현재 최단경로가 가장짧은녀석이므로 방문처리
            for (City city1 : graph.get(now)) {
                int cost = city1.getDistance() + dist;
                if(cost < d[city1.getIndex()]){
                    d[city1.getIndex()] = cost;
                    pq.offer(new City(city1.getIndex(), cost));
                }
            }
        }
    }
}
