package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9655_r {
    static int N;
    static int[] dp = new int[1001];
    //0 : SK, 1 : CY
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 0;

        for(int i = 4; i <= 1000; i++){
            dp[i] = dp[i - 1] == 0 ? 1 : 0;
        }

        if(dp[N] == 0){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }
}
