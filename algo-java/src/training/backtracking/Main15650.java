package training.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15650 {
    static int N, M;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];

        recursive(0, 0);
    }
    static void recursive(int start, int m){
        if(m == M){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < N; i++){
                if(visited[i]) sb.append(i + 1 + " ");
            }
            System.out.println(sb);

            return;
        }
        for(int i = start; i < N; i++){
            visited[i] = true;
            recursive(i + 1, m + 1);
            visited[i] = false;
        }


    }
}
