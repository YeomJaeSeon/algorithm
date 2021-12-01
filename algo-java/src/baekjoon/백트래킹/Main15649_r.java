package baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// == 백트래킹 풀었던 문제 모두 풀어보자. == //
public class Main15649_r {
    static int N, M;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        result = new int[M];

        recursive(0);

    }
    static void recursive(int m){
        if(m == M){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < M; i++){
                sb.append(result[i] + " ");
            }
            System.out.println(sb.toString());

            return;
        }
        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                result[m] = i + 1;
                recursive(m + 1);
                visited[i] = false;

            }
        }
    }
}
