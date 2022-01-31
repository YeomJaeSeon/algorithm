package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main2407 {
    static int n, m;
    static BigInteger[][] dp = new BigInteger[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //nCm
        BigInteger up = BigInteger.ONE;
        for(int i = 0; i < m; i++){
            up = up.multiply(new BigInteger(String.valueOf(n - i)));
        }

        BigInteger down = BigInteger.ONE;
        for(int i = 1; i <= m; i++){
            down = down.multiply(new BigInteger(String.valueOf(i)));
        }

        System.out.println(up.divide(down));
    }
}

/**
 * nCr = nPr / r!
 * 공식으로 그냥 구혀면됨
 *
 * 다만 int, long모두 택도없으므로 BigInteger클래스를 사용해야한다.
 *
 * nCr = n-1Cr-1 + n-1Cr 을 구해도됨
 * 피보나치와같이 동적계획법을 사요하지않으면 시간초과남
 */