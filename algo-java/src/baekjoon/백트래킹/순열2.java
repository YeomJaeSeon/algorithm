package baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순열2 {
    static int N, M;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];
        visited = new boolean[N + 1];

        permutations(0);

    }
    static void permutations(int m){
        if(M == m){
            for(int i = 0; i < M; i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i < N + 1; i++){
            if(!visited[i]){
                visited[i] = true;
                result[m] = i;
                permutations(m + 1);
                visited[i] = false;
            }
        }
    }
}
