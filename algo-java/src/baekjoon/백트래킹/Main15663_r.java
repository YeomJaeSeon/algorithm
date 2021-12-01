package baekjoon.백트래킹;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main15663_r {
    static int N, M;
    static Set<String> listSet = new LinkedHashSet<>();
    static int[] arr;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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

        recursive(0);

        for (String s : listSet) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
    }
    static void recursive(int m){
        if(m == M){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < M; i++){
                sb.append(arr[result[i]] + " ");
            }
            listSet.add(sb.toString());

            return;
        }
        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                result[m] = i;
                recursive(m + 1);
                visited[i] = false;
            }
        }
    }
}
