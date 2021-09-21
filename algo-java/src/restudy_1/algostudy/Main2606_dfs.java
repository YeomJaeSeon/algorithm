package restudy_1.algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2606_dfs {
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
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        dfs(1, 0);

        int count = 0;
        for (boolean v : visited) {
            if(v) count++;
        }
        System.out.println(--count);
    }
    static void dfs(int current, int count){
        visited[current] = true;

        for (Integer nextNode : list.get(current)) {
            if(!visited[nextNode]){
                dfs(nextNode, count + 1);
            }
        }
    }
}
