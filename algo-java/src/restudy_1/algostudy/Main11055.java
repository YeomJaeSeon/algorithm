package restudy_1.algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1 100 2 50 60 3 5 6 7 8
 * 1 100 3 53 113 6 11 17 24 32
 */

public class Main11055 {
    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];

        if(N > 1){
            for(int i = 1; i < N; i++){
                int max = -1;
                //0 ~ i - 1까지 모두 탐색
                for(int j = i - 1; j >= 0; j--){
                    if(arr[i] > arr[j]){
                        //증가하면
                        max = Math.max(max, dp[j]);
                    }
                }
                if(max == -1) dp[i] = arr[i]; //증가부분수열의 첫 시작수열이면
                else dp[i] = arr[i] + max;
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());

    }

}

/**
 * 2 1 5 6 7
 *
 * 2 2 7 13 20
 */