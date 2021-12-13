package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main17626 {
    static int n;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];
        Arrays.fill(dp, 5);
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            int v = (int) Math.sqrt(i);

            if(v * v == i){
                //제곱수이면
                dp[i] = 1;
            }else {
                for(int j = v; j >= 1; j--){
                    dp[i] = Math.min(dp[i], dp[j * j] + dp[i - (j * j)]);
                }
            }

        }

        System.out.println(dp[n]);
    }
}
/**
 * 동적계획법
 *
 * 풀이
 * - 단순히 어떠한 수 i에 대해서 해당 수를 제곱근한 수의 메모이제이션 된 값과 i - (v*v)를 더하면 최적의 값이 나온은줄 착각함
 * - 18의 경우 3^2 + 3^2 로 2이다. 내가 생각한대로하면 4^2 + 1^2 + 1^2이다.
 *
 * 그러므로 해당 i의 제곱근 수만 확인하는게 아닌, 제곱근 이하의 수에 대해서 모두확인한다음 최소값을 dp테이블에 입력해야한다.
 *
 * 그래야 최소 값이 메모이제이션 된다.
 */
