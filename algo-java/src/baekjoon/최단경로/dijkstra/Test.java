package baekjoon.최단경로.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable{
    private int index;
    private int distance;

    public int getDistance() {
        return distance;
    }

    public int getIndex() {
        return index;
    }

    public Node(int index, int distance){
        this.index = index;
        this.distance = distance;
    }


    @Override
    public int compareTo(Object o) {
        if(o instanceof Node){
            Node no = (Node) o;
            return no.distance - this.distance;
        }
        return 0;
    }
}
public class Test {
    static int v, e, start; //노드 개수, 간선 개수, 시작노드 번호
    static int[] d;
    static List<List<Node>> graph = new ArrayList<>();
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        for(int i = 0; i < v + 1; i++) graph.add(new ArrayList<>());
        for(int i = 0; i < e; i++){
            String s = br.readLine();
            StringTokenizer st2 = new StringTokenizer(s, " ");
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());
            graph.get(a).add(new Node(b, c));
        }
        d = new int[v + 1];
        Arrays.fill(d, INF);
        dijkstra(start);

        for(int i = 1; i <= v; i++){
            System.out.println(d[i]);
        }

    }

    static void dijkstra(int start){
        d[start] = 0; // 자신의 노드까지의 거리는 0
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0)); // 시작노드로 가기위한 간선의 경로는 0
        // 우선순위큐에 처음넣는다.

        while(!pq.isEmpty()){
            Node selectedNode = pq.poll();
            int index = selectedNode.getIndex(); // 현재 노드번호 // 1
            int dist = selectedNode.getDistance(); // 현재 노드까지 가는데의 경로 // 0
            if(d[index] < dist) continue; // 이미 처리된 노드는 무시
            for(int i = 0; i < graph.get(index).size(); i++){ // 해당 노드가 갈수있는 노드들이 저장되어있음
                int cost = d[index] + graph.get(index).get(i).getDistance(); // '노드'까지 갈수있는 거리 + 본인 노드까지 오는데의 비용
                if(d[graph.get(index).get(i).getIndex()] > cost) { // 비용이 더작으면
                    d[graph.get(index).get(i).getIndex()] = cost; // dp테이블 갱신
                    pq.offer(new Node(graph.get(index).get(i).getIndex(), cost)); // 우선순위큐에는
                }
            }
        }
    }
}

/**
 최단경로문제
 다익스트라 알고리즘 - Priority Queue - 자바에선 Comparable 인터페이스 구현(compareTo)메서드 구현해서 최소힙으로 바꾼다음 사용한다.
 제일 작은 비용을 계속 dp 테이블에갱신해가며 한다.
 **/