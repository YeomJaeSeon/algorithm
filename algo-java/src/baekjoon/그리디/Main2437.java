package baekjoon.그리디;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2437 {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = Arrays.stream(arr).sum();
        visited = new boolean[N];
        for(int i = 1; i <= N; i++){
            combinations(0, 0, i, arr.length);
            bw.write("========\n");

        }
        bw.flush();
        bw.close();

    }
    private static void combinations(int startIdx, int m, int limit, int length) throws IOException{
        if(m == limit){
            for(int i = 0; i < visited.length; i++){
                if(visited[i]) bw.write(i + " ");
            }
            bw.write("\n");

            return;
        }
        for(int i = startIdx; i < length; i++){
            visited[i] = true;
            combinations(i + 1, m + 1, limit, length);
            visited[i] = false;
        }
    }
}
