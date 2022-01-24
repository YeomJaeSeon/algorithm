package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2579 {
    static int N;
    static int[] arr;
    static int[] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1];
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(N == 1){
            System.out.println(arr[1]);
        }else if(N == 2){
            System.out.println(arr[1] + arr[2]);
        }else if(N == 3){
            System.out.println(Math.max(arr[3] + arr[1], arr[2] + arr[3]));
        }else{
            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];
            dp[3] = Math.max(arr[3] + arr[1], arr[2] + arr[3]);
            for(int i = 4; i <= N; i++){
                dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]);
                dp[i] += arr[i];
            }
            System.out.println(dp[N]);
        }



    }
}

/**
 * 점화식
 * Di = max(Di-2 + Ai, Di-3 + Ai-1 + Ai)
 *
 * 마지막은 무조건밟아야하므로 두경우
 * 이전 밟았을 경우 vs  이전의 이전 밟았을 경우
 * 의 최대값이 최적의해임
 */
