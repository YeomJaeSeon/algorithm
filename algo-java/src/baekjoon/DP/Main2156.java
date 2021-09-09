package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main2156 {
    static int n;
    static int[] drinks;
    static int[] dp = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        drinks = new int[n + 1];
        for(int i = 1; i <= n; i++){
            drinks[i] = Integer.parseInt(br.readLine());
        }

        if(n >= 3){
            dp[1] = drinks[1];
            dp[2] = dp[1] + drinks[2];
            dp[3] = Math.max(dp[2], dp[1] + drinks[3]);
            for(int i = 3; i <= n; i++){
                int a = dp[i - 3] + drinks[i - 1] + drinks[i];
                int b = dp[i - 2] + drinks[i];
                int c = dp[i - 1];
                int max = IntStream.of(a, b, c).max().getAsInt();
                dp[i] = max;
            }
        }else if(n == 1){
            dp[n] = drinks[1];
        }else if(n == 2){
            dp[n] = drinks[1] + drinks[2];
        }

        System.out.println(dp[n]);
    }
}
