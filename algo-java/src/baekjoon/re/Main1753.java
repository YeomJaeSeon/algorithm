package baekjoon.re;

// 최단경로 - 다익스트라알고리즘 (우선순위 큐로 현재 노드에서최단 경로를뽑아냄)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable{
    private int index; // 이노드번호까지
    private int distance; // 의 경로

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }
    public Node(int index, int distance){
        this.index = index;
        this.distance = distance;
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
    static int V, E, start;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] d;
    static int INF = (int)1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        d = new int[V + 1];
        for(int i = 0; i < V + 1; i++) graph.add(new ArrayList<>());

        for(int i = 0; i < E; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());
            graph.get(a).add(new Node(b, c));
        }
        Arrays.fill(d, INF);
        dijkstra(start);
        for(int i = 1; i < V + 1; i++){
            if(d[i] == INF) System.out.println("INF");
            else System.out.println(d[i]);
        }
    }
    static void dijkstra(int start){
        d[start] = 0; //일단 자기자신까지의 경로는0
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int now = node.getIndex();
            int dist = node.getDistance();
            if(d[now] < dist) continue; //이미 방문처리됨
            for (Node nowNode : graph.get(now)) {
                int cost = dist + nowNode.getDistance();
                if(d[nowNode.getIndex()] > cost){
                    d[nowNode.getIndex()] = cost;
                    pq.offer(new Node(nowNode.getIndex(), cost));
                }
            }
        }
    }
}

// greedy : 우선순위큐에서 현재노드에서 가장 경로가 적은노드를 뽑는것
// dp : 현재노드에서 가장 작은 경로를 적는것
// 이 그리디알고리즘과 다이나믹 프로그래밍을 이용해서 다익스트라 알고리즘을 구현 - 최단경로(가중치O)