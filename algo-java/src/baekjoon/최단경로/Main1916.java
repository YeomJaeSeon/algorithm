package baekjoon.최단경로;

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

    public int getDistance() {
        return distance;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(City o) {
        return this.distance - o.distance;
    }
}

public class Main1916 {
    static int N, M; // 정점과 간선
    static List<List<City>> graph = new ArrayList<>();
    static int start, end;
    static int INF = (int)1e9;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        d = new int[N + 1];
        for(int i = 0; i < N + 1; i++)graph.add(new ArrayList<>());
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new City(b, c));
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        Arrays.fill(d, INF);
        dijkstra(start, end);
        System.out.println(d[end]);
    }
    static void dijkstra(int start, int end){
        d[start] = 0;
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.offer(new City(start, 0));

        while(!pq.isEmpty()){
            City city = pq.poll();
            int now = city.getIndex();
            int dist = city.getDistance();
            if(d[now] < dist){
                if(now == end) break;
                continue;
            }
            for (City nowCity : graph.get(now)) {
                int cost = dist + nowCity.getDistance();
                if(d[nowCity.getIndex()] > cost){
                    d[nowCity.getIndex()] = cost;
                    pq.offer(new City(nowCity.getIndex(), cost));
                }
            }
        }
    }
}

/**
 풀이
 1. start -> end까지의 최단경로
 2. 최단경로하니 다익스트라 알고리즘이 생각남.
 3. 다익스트라알고리즘은 그리디알고리즘과 dp알고리즘의 한종류, 현재 노드에서 최단경로뽑기 - 우선순위큐이용
 현재 노드까지의 최단경로를 dp테이블에 메모(메모이제이션)
 4. 위 두 방법을 이용해서 품

 결국 a노드에서 b노드까지의 최단경로를 구하려면 a노드에서 모드정점들끼리의 최단경로를구하며 b노드가 방문처리되면 !! d[now] < dist -> 그만둔다.
 **/