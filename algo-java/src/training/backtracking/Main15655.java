package training.backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15655 {
    static int N, M;
    static int[] arr;
    static int[] result;
    static boolean[] visited;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        recursive( 0);

        bw.flush();
        bw.close();
    }
    static void recursive(int m) throws IOException {
        if(m == M){
            for(int i = 0; i < M; i++){
                bw.write(arr[result[i]] + " ");
            }
            bw.write("\n");

            return;
        }

        for(int i = (m == 0) ? 0 : result[m - 1]; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                result[m] = i;
                recursive( m + 1);
            }
            visited[i] = false;
        }
    }
}
