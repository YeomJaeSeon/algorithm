package baekjoon.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1753 {
    static int V, E, start;
    static int[] d;
    static List<List<Node>> graph = new ArrayList<>();
    static int INF = (int)390000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        for(int i = 0; i < V + 1; i++) graph.add(new ArrayList<>()); // graph 초기화
        for(int i = 0; i < E; i++){
            String s = br.readLine();
            StringTokenizer st2 = new StringTokenizer(s, " ");
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());
            graph.get(a).add(new Node(b, c)); // graph 초기화
        }
        d = new int[V + 1];
        Arrays.fill(d, INF);
        dijkstra(start);

        for(int i = 1; i < V + 1; i++){
            if(d[i] == INF) System.out.println("INF");
            else System.out.println(d[i]);
        }

    }
    public static void dijkstra(int start){
        d[start] = 0; // 처음 자기자신에게 가는 경로는 0
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int now = node.getIndex(); // 현재 노드
            int dist = node.getDistance(); // 현재노드까지의 경로
            if(d[now] < dist) continue; // 이미 방문처리됨
            for(int i = 0; i < graph.get(now).size(); i++){
                int cost = d[now] + graph.get(now).get(i).getDistance(); // 현재까지의 비용
                if(d[graph.get(now).get(i).getIndex()] > cost){
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }
}

class Node implements Comparable{
    private int index; // 노드번호
    private int distance; // 본인 노드까지의 경로

    public Node(int index, int distance){
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
    public int compareTo(Object o) {
        if(o instanceof Node){
            Node other = (Node) o;
            return this.distance - other.distance; // 3 - 4 => 음수 - 음수가 왼쪽, 양수는 오른쪽 - 최소힙이므로 정렬기준 오름차순 으로 정렬하도록 기준을준다.
        }
        return 0;
    }
}

/**
 단순 dfs로 푸려하니 시간초과...
 최단경로 문제에서 정점 개수가 2만이넘어가면 우선순위큐를 사용하는 다익스트라 알고리즘 사용해야한다.
 다익스트라 알고리즘으로 변경한뒤 또 틀린이유는 Java에서 PriorityQueue 정렬기준을 최대힙으로해서..
 최소힙으로해야한다. 최단경로이므로
 **/