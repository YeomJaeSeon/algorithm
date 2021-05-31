package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main10422 {
    static int T;
    static long[] d = new long[5001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        d[2] = 1;
        for(int i = 4; i < 5001; i++){
            if(i % 2 == 0){
                d[i] = ((d[i - 2] - 1) * 3 + 2) % 1_000_000_007;
            }
        }
        System.out.println(Arrays.toString(d));

        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int idx = Integer.parseInt(br.readLine());
            System.out.println(d[idx] % 1_000_000_007);
        }
    }
}
