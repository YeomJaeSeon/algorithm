package baekjoon.그래프탐색;

import java.io.*;
import java.util.*;

public class Main1325 {
    static int N, M;
    static List<List<Integer>> list = new ArrayList<>();
    static int max = -1;
    static boolean[] visited;
    static List<Integer> result = new ArrayList<>(10001);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];

        for(int i = 0; i < N + 1; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(b).add(a);
        }

        for(int i = 1; i <= N; i++){
            Arrays.fill(visited, false);
            int value = bfs(i);
            if(value > max){
                result.clear();
                max = value;
                result.add(i);
            }else if(max == value){
                result.add(i);
            }
        }

        Collections.sort(result);
        for (Integer integer : result) {
            bw.write(integer + " ");
        }
        bw.flush();
        bw.close();
    }
    static int bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        int count = 0;

        while (!q.isEmpty()){
            Integer current = q.poll();
            count++;
            for (Integer next : list.get(current)) {
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        return count;
    }
}
