package baekjoon.re.다익스트라알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Nod implements Comparable<Nod>{
    private int index;
    private int distance;

    public Nod(int index, int distance){
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
    public int compareTo(Nod o) {
        return distance - o.distance;
    }
}

public class ReMain1753 {
    static int V, E, start;
    static List<List<Nod>> graph = new ArrayList<>();
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
        d = new int[V + 1];
        visited = new boolean[V + 1];

        for(int i = 0; i < E; i++){
            String s = br.readLine();
            StringTokenizer st2 = new StringTokenizer(s, " ");
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());
            int distance = Integer.parseInt(st2.nextToken());
            graph.get(start).add(new Nod(end, distance));
        }
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
        d[start] = 0;
        PriorityQueue<Nod> pq = new PriorityQueue<>();
        pq.offer(new Nod(start, 0));

        while(!pq.isEmpty()){
            Nod node = pq.poll();
            int now = node.getIndex();
            int dist = node.getDistance();
            if(visited[now]) continue;
            visited[now] = true; // 우선순위 큐에서 딱 꺼낸거는 현재까지의 최단경로로가는 노드를 꺼낸것이므로 방문처리 - Greedy algorithm
            for (Nod curNode : graph.get(now)) {
                int cost = dist + curNode.getDistance();
                if(cost < d[curNode.getIndex()]){
                    d[curNode.getIndex()] = cost;
                    pq.offer(new Nod(curNode.getIndex(), cost));
                }
            }
        }
    }
}
