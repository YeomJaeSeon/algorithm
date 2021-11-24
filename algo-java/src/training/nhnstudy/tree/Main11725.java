package training.nhnstudy.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main11725 {
    static int N;
    static List<List<Integer>> list;
    static boolean[] visited = new boolean[100001];
    static int[] parent = new int[100001];

    // == 트리 만들기 == //
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>(N + 1);
        for(int i = 0; i < N + 1; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        bfs();

        for(int i = 2; i < N + 1; i++){
            System.out.println(parent[i]);
        }
    }
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;

        while(!q.isEmpty()){
            Integer v = q.poll();
            for (Integer m : list.get(v)) {
                if(!visited[m]){
                    parent[m] = v;
                    visited[m] = true;
                    q.offer(m);
                }
            }
        }
    }
}