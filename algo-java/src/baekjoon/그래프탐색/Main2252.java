package baekjoon.그래프탐색;
// 위상정렬
// 사이클이 없는 진입 간선이 있는 노드들의 그래프에 대해서
// 정렬하는 알고리즘
// 큐를 이용하고 그냥 큐에넣는다면 여러개의 답이 나올수있다.

import java.io.*;
import java.util.*;

public class Main2252 {
    static int N, M;
    static int[] degree;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] result;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        degree = new int[N + 1];
        result = new int[N + 1];

        for(int i = 0; i < N + 1; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            list.get(a).add(b);
            degree[b]++;
        }

        topologySort();

        bw.flush();
        bw.close();
    }
    //위상정렬
    static void topologySort() throws IOException{
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i < N + 1; i++){
            if(degree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int v = q.poll();
            bw.write(v + " ");

            if(list.get(v).size() > 0) {
                for (Integer v2 : list.get(v)) {
                    if (--degree[v2] == 0) q.offer(v2);
                }
            }
        }
    }
}
/**
 * 위상정렬
 * - 사이클이 없는 그래프에서 어떠한 노드로갈때의 조건이있는경우 정렬
 * - 중요한건 진입차수가 없는 노드부터 큐에 넣어서 빼는것이 정렬이다.
 * - 정렬결과가 여러개가 나올수가있다
 */
