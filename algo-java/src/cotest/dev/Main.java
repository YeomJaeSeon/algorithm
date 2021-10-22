package cotest.dev;

import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    }
    static int solution(int n, int[][] wires){
        int answer = -1;
        for(int i = 0; i < n + 1; i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];

        for(int i = 0; i < wires.length; i++){
            int connectA = wires[i][0];
            int connectB = wires[i][1];

            graph.get(connectA).add(connectB);
            graph.get(connectB).add(connectA);
            //양방향
        }
        System.out.println("원본");
        System.out.println(graph);

        for(int i = 0; i < wires.length; i++){
            int disconnectA = wires[i][0];
            int disconnectB = wires[i][1];
            int changeIdxA = 0;
            int changeIdxB = 0;

            for(int j = 0; j < graph.get(disconnectA).size(); j++){
                if(graph.get(disconnectA).get(j) == disconnectB){
                    graph.get(disconnectA).set(j, -1);
                    changeIdxA = j;
                }
            }
            for(int j = 0; j < graph.get(disconnectB).size(); j++){
                if(graph.get(disconnectB).get(j) == disconnectA){
                    graph.get(disconnectB).set(j, -1);
                    changeIdxB = j;
                }
            }

            List<Integer> topCount = new ArrayList<>(2);

            for(int j = 1; j <= n; j++){
                int count = bfs(j);
                if(count != 0) topCount.add(count);
            }

            System.out.println(topCount);
            System.out.println(graph);

            graph.get(disconnectA).set(changeIdxA, disconnectB);
            graph.get(disconnectB).set(changeIdxB, disconnectA);
            Arrays.fill(visited, false); // 방문처리 초기화
        }

        return answer;
    }
    static int bfs(int node){
        if(visited[node]) return 0;
        visited[node] = true; // 방문처리
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);

        int visitCount = 1;

        while(!q.isEmpty()){
            int v = q.poll();
            for(Integer curNode : graph.get(v)){
                if(!visited[curNode] && curNode != -1){ //방문안했고, 연결끊어진상태가아니면
                    q.offer(curNode);
                    visited[curNode] = true; //방문처리
                    visitCount++;
                }
            }
        }

        return visitCount;
    }
}
