package baekjoon.re.다익스트라알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point implements Comparable<Point>{
    private int index;
    private int distance;

    public Point(int index, int distance){
        this.index = index;
        this.distance =distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Point o) {
        return distance - o.distance;
    }
}

public class ReReMain1753 {
    static int V, E, start;
    static List<List<Point>> graph = new ArrayList<>();
    static int[] d;
    static boolean[] visited;
    static int INF = (int)1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        for(int i = 0; i < V + 1; i++) graph.add(new ArrayList<>());
        for(int i = 0; i < E; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());

            graph.get(a).add(new Point(b, c));
        }

        d = new int[V + 1];
        visited = new boolean[V + 1];

        Arrays.fill(d, INF);
        dijkstra(start);

        for(int i = 1; i < V + 1; i++){
            if(d[i] == INF){
                System.out.println("INF");
            }else{
                System.out.println(d[i]);
            }
        }


    }
    static void dijkstra(int start){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.offer(new Point(start, 0));

        while(!pq.isEmpty()){
            Point p = pq.poll();
            int now = p.getIndex();
            int dist = p.getDistance();
            if(visited[now]){
                continue;
            }
            visited[now] = true; // 우선순위 큐에서나온 녀석은 현재 노드에서
            //가장가까운녀석이므로 방문처리 - greedy알고리즘

            for (Point point : graph.get(now)) {
                int cost = dist + point.getDistance();
                if(d[point.getIndex()] > cost){
                    d[point.getIndex()] = cost;
                    pq.offer(new Point(point.getIndex(), cost));
                }
            }
        }
    }
}
