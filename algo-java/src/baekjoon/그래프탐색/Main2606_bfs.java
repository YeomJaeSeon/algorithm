package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// BFS, DFS study
public class Main2606_bfs {
    static int totalCnt;
    static int N, V;
    static boolean[] visited;
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        V = Integer.parseInt(br.readLine());
        for(int i = 0; i < N + 1; i++) list.add(new ArrayList<>());

        for(int i = 0; i < V; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list.get(from).add(to);
            list.get(to).add(from);
        }
        visited = new boolean[N + 1];

        bfs();

        System.out.println(totalCnt - 1);
    }
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        while(!q.isEmpty()){
            int v = q.poll();
            totalCnt++;

            for(Integer node : list.get(v)){
                if(!visited[node]){
                    q.offer(node);
                    // 방문처리를 요기서해줘야함 bfs는 Queue에서 poll하는곳에서
                    // 방문처리하면 중복된값이 큐에들어갈수있음
                    visited[node] = true;
                }
            }
        }
    }
}
/**
 bfs는 방문처리 하는 위치를 주의하자
 Queue에 원소를 넣을때, 방문처리해야 큐에 중복된값이 들어가지않는다.
 큐에서 poll할때, 방문처리하면 큐에 중복된 값이 들어갈수있음
 한번만 방문하고싶으면 큐에 원소를 넣을때 방문처리하자!!!

 큐에 원소를 넣을때 방문처리함으로 중복된 방문 방지!! 꼭기억

 **/