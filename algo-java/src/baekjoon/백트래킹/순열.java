package baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순열 {
    static int N, M;
    static boolean[] visited;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        result = new int[M];
        permutations(0, N);

    }
    static void permutations(int m, int length){
        if(m == M){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < M; i++){
                sb.append(result[i] + " " );
            }
            System.out.println(sb);

            return;
        }
        //순열은 1부터, 조합과다름
        for(int i = 1; i < length + 1; i++){
            if(!visited[i]){
                visited[i] = true;
                result[m] = i;
                permutations(m + 1, length);
                visited[i] = false;
            }
        }
    }
}
