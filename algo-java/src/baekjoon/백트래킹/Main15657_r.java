package baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15657_r {
    static int N, M;
    static int[] arr;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        recursive(0);
    }
    static void recursive(int m){
        if(m == M){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < M; i++){
                sb.append(arr[result[i]] + " ");
            }
            System.out.println(sb.toString());

            return;
        }

        for(int i = (m == 0) ? 0 : result[m - 1]; i < N; i++){
            result[m] = i;
            recursive(m + 1);
        }
    }
}
