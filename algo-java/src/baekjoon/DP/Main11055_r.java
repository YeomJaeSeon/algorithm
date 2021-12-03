package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11055_r {
    static int N;
    static int[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];

        for(int i = 1; i < N; i++){
            for(int j = i - 1; j >= 0; j--){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += arr[i];
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
