package restudy_1.algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2606 {
    static int N, M;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a); //양방향
        }

        System.out.println(bfs());

    }
    static int bfs(){
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;

        while(!q.isEmpty()){
            Integer current = q.poll();
            for (Integer nextNode : list.get(current)) {
                if(!visited[nextNode]){
                    q.offer(nextNode);
                    visited[nextNode] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
