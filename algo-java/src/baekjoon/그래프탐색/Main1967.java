package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1967 {
    static boolean[] visited;
    static Map<Integer, Integer>[] graph;
    static int max = 0; // 트리 전체의 max
    static int sum = 0; // 합저장할변수
    static int subMax = 0; // 노드 하나의 max

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] inputArr = new int[n - 1][3]; // 최대 10,000 * 3 * 4 = 120,000
        for(int i = 0; i < n - 1; i++){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, " ");
            inputArr[i][0] = Integer.parseInt(st.nextToken());
            inputArr[i][1] = Integer.parseInt(st.nextToken());
            inputArr[i][2] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[n + 1]; // 10,000 * 1 = 10,000
        graph = new Map[n + 1]; // 10,000 * 24 = 240,000

        for(int i = 0; i < graph.length; i++){
            graph[i] = new HashMap<>();
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 0; j < inputArr.length; j++){
                if(inputArr[j][0] > i) break; // 부모 노드는 항상 자식노드보다 작다.
                if(inputArr[j][0] == i){
                    graph[i].put(inputArr[j][1], inputArr[j][2]);
                }
                if(inputArr[j][1] == i){
                    graph[i].put(inputArr[j][0], inputArr[j][2]);
                }
            }
        }

        System.out.println(Arrays.toString(graph));

        // graph : [Map, Map, Map ... ]
        // Map key : 연결된 node, value : 간선의 가중치
        for(int i = 1; i < n + 1; i++){
            dfs(i);
            max = Math.max(max, subMax);
            sum = 0;
            Arrays.fill(visited, false);
        }
        System.out.println(max);
    }
    public static void dfs(int startNode){
        visited[startNode] = true;

        Iterator<Map.Entry<Integer, Integer>> iterator = graph[startNode].entrySet().iterator();

        // key는 연결된 node, value 가중치
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            int nextNode = next.getKey();
            int gravity = next.getValue();
            if(!visited[nextNode]){
                sum += gravity;
                dfs(nextNode);
                subMax = Math.max(sum, subMax);
                sum -= gravity;
            }
        }

    }
}
