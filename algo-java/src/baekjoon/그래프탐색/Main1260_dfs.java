package baekjoon.그래프탐색;

import java.io.*;
import java.util.*;

public class Main1260_dfs {
    static int N, M, V;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N + 1; i++){
            list.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " " );
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a); //양방향
        }
        for(int i = 1; i < N + 1; i++){
            Collections.sort(list.get(i)); // 정렬
        }

        dfs(V);
        bw.write("\n");
        Arrays.fill(visited, false);
        bfs(V);


        bw.flush();
        bw.close();
    }
    static void dfs(int start) throws IOException {
        visited[start] = true;
        bw.write(start + " " );


        for(Integer node : list.get(start)){
            if(!visited[node]){
                dfs(node);
            }
        }
    }
    static void bfs(int start) throws IOException{
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int v = q.poll();
            bw.write(v + " ");
            for(Integer node : list.get(v)){
                if(!visited[node]) q.offer(node);
                visited[node] = true;
            }
        }
    }
}
