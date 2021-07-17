package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1389 {
    static int N, M;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int person = 0;

        for(int i = 0; i < N + 1; i++) list.add(new ArrayList<>());
        visited = new int[N + 1];
        Arrays.fill(visited, -1);

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            list.get(to).add(from); // 양방향
        }

        for(int i = 1;  i < N + 1; i++){
            Collections.sort(list.get(i));
        }

        for(int i = 1; i < N + 1; i++){
            bfs(i);
            int sum = Arrays.stream(visited).filter(o -> o != -1)
                    .filter(o -> o != 0).sum();
            if(min >= sum){
                if(min == sum){
                    person = Math.min(person, i);
                }else{
                    person = i;
                }
                min = sum;
            }
            Arrays.fill(visited, -1);
        }

        System.out.println(person);

    }
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = 0;

        while(!q.isEmpty()){
            int v = q.poll();
            for (Integer node : list.get(v)) {
                if(visited[node] == -1){
                    q.offer(node);
                    visited[node] = visited[v] + 1;
                }
            }
        }
    }
}
