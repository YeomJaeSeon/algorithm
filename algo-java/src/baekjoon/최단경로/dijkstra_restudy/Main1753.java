package baekjoon.최단경로.dijkstra_restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 최단경로 -다익스트라 알고리즘
 * Greedy + DP
 * - 우선순위큐를 사용해서 가장 경로 가까운걸 꺼낸게 최단경로
 * - DP : 메모해가며 처리
 */

class Node implements Comparable<Node>{
    private int index;
    private int distance;

    public int getDistance() {
        return distance;
    }

    public int getIndex() {
        return index;
    }

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }


    @Override
    public int compareTo(Node o) {
        return distance - o.distance;
    }
}

public class Main1753 {
    static int V, E, start;
    static int[] d;
    static boolean[] visited;
    static List<List<Node>> graph = new ArrayList<>();
    static final int INF = (int)1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        d = new int[V + 1];
        visited = new boolean[V + 1];

        for(int i = 0; i < V + 1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());

            graph.get(a).add(new Node(b, c));
        }
        Arrays.fill(d, INF);

        dijkstra(start);

        for(int i = 1; i <= V; i++){
            if(d[i] == INF){
                System.out.println("INF");
            }else{
                System.out.println(d[i]);
            }
        }

    }
    static void dijkstra(int start){
        d[start] = 0; // 자기자신까진 0
        PriorityQueue<Node> pq = new PriorityQueue<>(); // 현재노드에서 가장가까운걸
        //꺼낼것 - 그리디알고리즘을 위한 우선순위큐
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node poll = pq.poll(); // 우선순위큐에서 꺼내진 노드는 최단경로임.
            int now = poll.getIndex();
            int dist = poll.getDistance();

            if(visited[now]) continue;
            visited[now] = true;

            for (Node node : graph.get(now)) {
                int cost = dist + node.getDistance();
                if(cost < d[node.getIndex()]){
                    d[node.getIndex()] = cost;
                    pq.offer(new Node(node.getIndex(), cost));
                }
            }
        }
    }
}
