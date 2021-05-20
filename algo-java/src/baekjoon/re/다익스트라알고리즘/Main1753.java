package baekjoon.re.다익스트라알고리즘;

// 최단경로 - 다익스트라 알고리즘 (우선순위 큐)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable{
    private int index;
    private int distance;

    public Node(int index, int distance){
        this.index = index; // 노드 번호
        this.distance = distance; // 해당 노드 까지의 경로
    }

    public int getDistance() {
        return distance;
    }

    public int getIndex() {
        return index;
    }


    @Override
    public int compareTo(Object o) {
        if(o instanceof Node){
            Node other = (Node) o;
            return this.distance - other.distance;
        }
        return 0;
    }
}

public class Main1753 {
    static int V, E, start; //정점 간선, 시작번호
    static int[] d; // dp 테이블(최단경로 가지고있는)
    static List<List<Node>> graph = new ArrayList<>();
    static final int INF = (int)1e9;

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int now = node.getIndex();
            int dist = node.getDistance();
            if(d[now] < dist) continue; // 방문처리됨 - 현재 노드의 최적의해가 dist보다 작으면 이미 방문처리된거임
            for(int i = 0; i < graph.get(now).size(); i++){
                int cost = d[now] + graph.get(now).get(i).getDistance();
                if(cost < d[graph.get(now).get(i).getIndex()]){
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        d = new int[V + 1];
        int start = Integer.parseInt(br.readLine());
        for(int i = 0; i < V + 1; i++) graph.add(new ArrayList<>());
        for(int i = 0; i < E; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());

            graph.get(a).add(new Node(b, c)); // 노드정보를 list에 저장
        }
        Arrays.fill(d, INF);
        dijkstra(start);

        for(int i = 1; i < V + 1; i++){
            if(d[i] == INF) System.out.println("INF");
            else System.out.println(d[i]);
        }
    }
}
