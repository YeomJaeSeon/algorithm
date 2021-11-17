package training.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2839 {
    static int N;
    static int[] dp = new int[5001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp[0] = -1;
        dp[1] = -1;
        dp[2] = -1;
        dp[3] = 1;
        dp[4] = -1;
        dp[5] = 1;
        for(int i = 6; i < 5001; i++){
            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;
            if(dp[i - 3] != -1){
                a = dp[i - 3] + 1;
            }
            if(dp[i - 5] != -1){
                b = dp[i - 5] + 1;
            }
            int min = Math.min(a, b);
            if(min == Integer.MAX_VALUE) dp[i] = -1;
            else dp[i] = min;
        }

        System.out.println(dp[N]);
    }
}
