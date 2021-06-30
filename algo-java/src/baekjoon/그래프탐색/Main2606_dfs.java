package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// BFS, DFS study
public class Main2606_dfs {
    static int count;
    static int N, V;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        V = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        for(int i = 0; i < N + 1; i++) list.add(new ArrayList<>());

        for(int i = 0; i < V; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list.get(from).add(to);
            list.get(to).add(from);
        }

        dfs(1);

        // 1번 제외
        System.out.println(count - 1);
    }
    static void dfs(int startNode){
        visited[startNode] = true;
        count++;

        for(Integer node : list.get(startNode)){
            if(!visited[node]){
                dfs(node);
            }
        }
    }

}

/**
 dfs로
 인접리스트행렬로품
 나는 그래프탐색 문제는 인접리스트행렬이편함..

 틀린이유는
 양방향관계를 추가안해줌
 list.get(to).add(from);도 해야함.
 **/