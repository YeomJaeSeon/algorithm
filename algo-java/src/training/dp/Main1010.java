package training.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1010 {
    static int T, N, M;
    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        int v = 1;

        // dp table 초기화
        for(int i = 1; i < 30; i++){
            for(int j = i; j < 30; j++){
                if(i == 1) {
                    dp[i][j] = v++;
                    continue;
                }
                if(i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
            }
        }

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            System.out.println(dp[N][M]);
        }

    }
}
