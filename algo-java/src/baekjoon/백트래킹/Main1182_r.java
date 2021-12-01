package baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1182_r {
    static int N, S;
    static int[] arr;
    static int[] result;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++){
            result = new int[i];
            recursive(i, 0, 0);
        }
        System.out.println(count);
    }
    static void recursive(int M, int m, int start){
        if(M == m){
            int sum = 0;
            for(int i = 0; i < M; i++){
                sum += arr[result[i]];
            }
            if(sum == S) count++;

            return;
        }
        for(int i = start; i < N; i++){
            result[m] = i;
            recursive(M, m + 1, i + 1);
        }
    }
}
