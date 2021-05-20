package baekjoon.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class N{
    private int index;
    private int distance;

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    public N(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

}

public class Test2{
    static int v, e, start;
    static List<List<N>> graph = new ArrayList<>();
    static int[] d;
    public static boolean[] visited = new boolean[100001];

    public static N getSmallestNode(List<N> list){
        Optional<N> min = list.stream().min((a, b) -> a.getDistance() - b.getDistance());
        return min.get();
    }

    public static void dijkstra(int start){
        d[start] = 0;
        visited[start] = true;

        for(int j = 0; j < graph.get(start).size(); j++){
            d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
        }
        for(int i = 0; i < v - 1; i++){
            int now = getSmallestNode(graph.get(start)).getIndex();
            visited[now] = true;

            for(int j = 0; j < graph.get(now).size(); j++){
                int cost = d[now] + graph.get(now).get(j).getDistance();
                if(cost < d[graph.get(now).get(j).getIndex()]) d[graph.get(now).get(j).getIndex()] = cost;
            }
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        d = new int[v + 1];
        for(int i = 0; i < v + 1; i++){
           graph.add(new ArrayList<>());
        }
        for(int i = 0; i < e; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st2.nextToken());
            int b= Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());

            graph.get(a).add(new N(b, c));
        }
        Arrays.fill(d, (int)1e9);
        dijkstra(start);

        for(int i = 1; i <= v; i++){
            if(d[i] == (int)1e9)
                System.out.println("INF");
            else System.out.println(d[i]);
        }
    }
}