package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1912 {
    static int N;
    static int[] arr;
    static int[] dp = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, -1001);

        dp[1] = arr[1];
        for(int i = 2; i <= N; i++){
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
