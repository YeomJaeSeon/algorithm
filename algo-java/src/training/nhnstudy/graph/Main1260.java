package training.nhnstudy.graph;

import java.io.*;
import java.util.*;

public class Main1260 {
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

        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
            //양방향
        }

        //오름차순 정렬
        for (List<Integer> subList : list) {
            Collections.sort(subList);
        }

        visited = new boolean[N + 1];
        dfs(V);
        bw.write("\n");

        visited = new boolean[N + 1];
        bfs(V);

        bw.flush();
        bw.close();
    }
    static void dfs(int start) throws IOException {
        visited[start] = true;
        bw.write(start + " ");
        for (Integer next : list.get(start)) {
            if(!visited[next]){
                visited[next] = true;
                dfs(next);
            }
        }
    }
    static void bfs(int start) throws IOException{
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()){
            Integer current = q.poll();
            bw.write(current + " ");
            for (Integer next : list.get(current)) {
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}
