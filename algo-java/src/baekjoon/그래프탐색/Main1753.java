package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main1753 {
    static int[] board; // 결과
    static int V; // 정점의 개수
    static int E; // 간선의개수
    static int startNode; //탐색 시작 정점번호
    static List<int[]>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수
        startNode = Integer.parseInt(br.readLine());
        graph = new List[V + 1];
        board = new int[V + 1];
        visited = new boolean[V + 1];
        Arrays.fill(board, -1);
        for(int i = 0; i <= V; i++) graph[i] = new ArrayList<>();
        for(int i = 0; i < E; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());
            int w = Integer.parseInt(st2.nextToken());
            int[] info = new int[]{v, w};
            graph[u].add(info);
        }
        board[startNode] = 0; // 자기자신
        dfs(startNode, 0);
        for(int i = 1; i <= V; i++){
            if(board[i] == -1) System.out.println("INF");
            else System.out.println(board[i]);
        }

    }
    static void dfs(int startNode, int sum){
        for (int[] nodes : graph[startNode]) {
                sum += nodes[1];
                if(board[nodes[0]] == -1) board[nodes[0]] = sum;
                else{
                    if(board[nodes[0]] > sum){
                        board[nodes[0]] = sum;
                        return;
                    }
                }
                dfs(nodes[0], sum);
                sum -= nodes[1];
        }
    }
}
