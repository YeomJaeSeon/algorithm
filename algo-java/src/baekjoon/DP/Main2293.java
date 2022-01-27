package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제예시
 * 동적계획법 - problem, subproblem으로 나누기
 * F(10) = F(9) + F(8) + F(5)
 */

public class Main2293 {
    static int n, k;
    static int[] dp;
    static int[] coin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[k + 1];
        coin = new int[n + 1];

        for(int i = 1; i <= n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;

        for(int i = 1; i <= n; i++){
            for(int j = coin[i]; j <= k; j++){
                dp[j] += dp[j - coin[i]];
            }
        }

        System.out.println(dp[k]);
    }
}

/**
 * dp는 problem을 sub problem으로 나눌수 있어야한다.
 * 어떻게 나눌지 알려면 많은 문제를 접해야함
 *
 * 문제예시에 따라 problem, sub problem나누어보자
 * F(10) = F(9) + F(8) + F(5)
 * 이렇게 sub problem으로 분할할수 있다.
 *
 * 이제 바텀업 방식으로 반복문을 이용해 풀자.
 *
 * dp[j] += dp[j - coin[i]]
 * 이러한 점화식으로 풀수있다.
 *
 * 솔직히 너무 어렵다.
 * 해설보면서 풀었다.
 * 동적계획법은 problem, sub problem으로 어떻게 분할할지를 판단하는 실력을 늘려야겠다.
 */