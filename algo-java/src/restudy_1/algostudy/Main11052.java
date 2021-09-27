package restudy_1.algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11052 {
    static int N;
    static int[] dp = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i < N + 1; i++){
            dp[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 2; i <= N; i++){
            for(int j = 1; j <= i / 2; j++){
                dp[i] = Math.max(dp[j] + dp[i - j], dp[i]);
            }
        }

        System.out.println(dp[N]);
    }
}
