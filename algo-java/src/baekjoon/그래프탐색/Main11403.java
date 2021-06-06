package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main11403 {
    static List<List<Integer>> graph = new ArrayList<>();
    static int N;
    static boolean[] visited;
    static int[][] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < N + 1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i < N + 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j= 1; j < N + 1; j++){
                int nextV = Integer.parseInt(st.nextToken());
                if(nextV == 1){
                    graph.get(i).add(j);
                }
            }
        }

        for(int i = 1; i < N + 1; i++){
            bfs(i);
            Arrays.fill(visited, false);
        }

        for(int i = 1; i < N + 1; i++){
            for(int j = 1; j < N + 1; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }


    }
    static void bfs(int start){
        Queue<Integer> q = new LinkedList();
        q.offer(start);


        while(!q.isEmpty()){
            int v = q.poll();
            if(start != v) {
                result[start][v] = 1;
                visited[v] = true;
            }
            for (Integer node : graph.get(v)) {
                if(!visited[node]) {
                    q.offer(node);
                    if(node == start) result[start][start] = 1;
                }
            }
        }
    }
}

/**
 간단한 그래프탐색문제임
 bfs로품
 visited를 통해서 방문한 노드 다시 방문하지않아..

 1번 틀림
 - 처음 시작 한 start노드는 바로 방문처리를 하며안댐.. 이게 출력조건임
 - 그걸 놓침침 **/