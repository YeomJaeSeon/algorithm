package baekjoon.백트래킹;

import java.io.*;
import java.util.StringTokenizer;

public class Main15651 {
    static int N, M;
    static boolean[] visited;
    static int[] result;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        result = new int[M];

        permutations(0, N);

        bw.flush();
        bw.close();
    }
    static void permutations(int m, int length) throws IOException {
        if (m == M) {
            for(int i = 0; i < m; i++){
                bw.write(result[i] + " ");
            }
            bw.write("\n");

            return;
        }
        for(int i = 1; i < N + 1; i++){
            visited[i] = true;
            result[m] = i;
            permutations(m + 1, length);
            visited[i] = false;
        }
    }
}

/**
 순열에서 살짞변형
 자기자신을 포함하면됨
 순열  + 자기자신

 **/