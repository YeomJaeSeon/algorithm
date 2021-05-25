package baekjoon.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point implements Comparable<Point>{
    private int index;
    private int distance;

    public Point(int index, int distance){
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
    public int compareTo(Point o) {
        return distance - o.distance;
    }
}

public class Main1504 {

    static int N, E;
    static int p1, p2;
    static int result1, result2;
    static List<List<Point>> graph = new ArrayList<>();
    static int[] d;
    static boolean[] visited;
    static int INF = (int)1e8;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N + 1; i++) graph.add(new ArrayList<>());

        for(int i = 0; i < E; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());

            graph.get(a).add(new Point(b, c));
            graph.get(b).add(new Point(a, c));
            // 양방향
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        p1 = Integer.parseInt(st2.nextToken());
        p2 = Integer.parseInt(st2.nextToken());

        visited = new boolean[N + 1];
        d = new int[N + 1];
        Arrays.fill(d, INF);

        // 1 -> p1 -> p2 -> N
        // 1 -> p1
        dijkstra(1, p1);
        result1 += d[p1];
        Arrays.fill(d, INF);
        Arrays.fill(visited, false);

        // p1 -> p2
        dijkstra(p1, p2);
        result1 += d[p2];
        Arrays.fill(d, INF);
        Arrays.fill(visited, false);

        // p2 -> N
        dijkstra(p2, N);
        result1 += d[N];
        Arrays.fill(d, INF);
        Arrays.fill(visited, false);


        // 1 -> p2 -> p1 -> N
        dijkstra(1, p2);
        result2 += d[p2];
        Arrays.fill(d, INF);
        Arrays.fill(visited, false);

        dijkstra(p2, p1);
        result2 += d[p1];
        Arrays.fill(d, INF);
        Arrays.fill(visited, false);

        dijkstra(p1, N);
        result2 += d[N];

        if(result1 >= INF && result2 >= INF){
            System.out.println(-1);
        }else{
            System.out.println(Math.min(result1, result2));
        }
    }
    static void dijkstra(int start, int end){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.offer(new Point(start, 0));

        while (!pq.isEmpty()){
            Point point = pq.poll();
            int now = point.getIndex();
            int dist = point.getDistance();

            if(visited[now]) continue;
            if(now == end) break;
            visited[now] = true;

            for (Point sPoint : graph.get(now)) {
                int cost = dist + sPoint.getDistance();
                if(d[sPoint.getIndex()] > cost){
                    d[sPoint.getIndex()] = cost;
                    pq.offer(new Point(sPoint.getIndex(), cost));
                }
            }
        }
    }
}

/**
 최단경로구하므로 다익스트라알고리즘 으로 풀면됨
 1. greedy - 우선순위큐에서 꺼낸건 현재 노드에서 가장 가까운녀석을 꺼냄 - 방문처리 (다시는 방문할 필요 X)
 2. dp - d[] 배열에 메모해나가며..

 - 우선 양방향이므로 애초에 입력받을때 양쪽 모두의 노드로 갈수있고 비용같게 graph를 설정
 - 두 정점을 거쳐야한다. 두정점을 거치는건 1 -> p1 -> p2 -> N
 1 -> p2 -> p1 -> N
 - 위 두경우밖에없으므로 위두경우의 최솟값이 답임
 - 참고로 경로가 없을수도있으므로 예외처리를 해줘야함 - 예외처리 못해서 틀림
 - (int)1e9는 오버플로우로 이상한값이 나와서 틀렸음..

 **/