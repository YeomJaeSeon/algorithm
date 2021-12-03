package baekjoon.백트래킹;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main6443 {
    static int N;
    static char[] arr;
    static int[] result;
    static boolean[] visited;
    static Set<String> listSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        //test case
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            arr = str.toCharArray();
            Arrays.sort(arr);

            result = new int[arr.length];
            visited = new boolean[arr.length];
            listSet = new LinkedHashSet<>();
            //여기까지 test case마다 변수 초기화 작업

            recursive(0, arr.length);

            for (String s : listSet) {
                bw.write(s + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
    static void recursive(int m, int M){
        if(m == M){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < M; i++){
                sb.append(arr[result[i]]);
            }
            listSet.add(sb.toString());

            return;
        }
        for(int i = 0; i < M; i++){
            if(!visited[i]){
                visited[i] = true;
                result[m] = i;
                recursive(m + 1, M);

                visited[i] = false;
            }
        }

    }
}
