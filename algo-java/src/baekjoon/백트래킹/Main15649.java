package baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15649 {
    static boolean[] visited;
    static int N, M;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        result = new int[M];

        permutations(0);
    }
    static void permutations(int m){
        if(M == m){
            StringBuilder sb = new StringBuilder();
            for(int i : result){
                sb.append(i + " ");
            }
            System.out.println(sb);
            return;
        }
        for(int i = 1; i < N + 1; i++){
            //방문 X
            if(!visited[i]){
                visited[i] = true;
                result[m] = i;
                permutations(m + 1);
                visited[i] = false;
            }
        }
    }

}
