package training.nhnstudy.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2606 {
    static int N, M;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        for(int i = 0; i < N + 1; i++){
            list.add(new ArrayList<>());
        }


        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

//        bfs();

        dfs(1);
        System.out.println(count);
    }
    static void dfs(int start){
        visited[start] = true;
//        System.out.println(start);

        for (Integer next : list.get(start)) {
            if(!visited[next]){
                visited[next] = true;
                count++;
                dfs(next);
            }
        }
    }
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;

        while(!q.isEmpty()){
            Integer current = q.poll();
            for (Integer next : list.get(current)) {
                if(!visited[next]){
                    visited[next] = true;
                    count++;
                    q.offer(next);
                }
            }
        }
    }
}
