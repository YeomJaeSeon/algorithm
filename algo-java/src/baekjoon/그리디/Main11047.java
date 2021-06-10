package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11047 {
    static int N, K;
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        p = new int[N];
        for(int i = 0; i < N; i++){
            p[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;

        for(int i = N - 1; i >= 0; i--){
            if(K >= p[i]){
                count += (K / p[i]);
                K = K % p[i];
            }
        }
        System.out.println(count);

    }
}
