package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1 1 1 2 2 3 4 5 7 9 12 16 21 28
public class Main9461 {
    static int T;
    static long[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            if(N <= 11) d = new long[12];
            else d = new long[N + 1];
            d[1] = 1;
            d[2] = 1;
            d[3] = 1;
            d[4] = 2;
            d[5] = 2;
            d[6] = 3;
            d[7] = 4;
            d[8] = 5;
            d[9] = 7;
            d[10] = 9; // d[9] + d[5]
            d[11] = 12; // d[10] + d[6]
            if(N <= 11){
                System.out.println(d[N]);
                continue;
            }
            for(int j = 12; j <= N; j++){
                d[j] = d[j - 1] + d[j - 5];
            }
            System.out.println(d[N]);
        }
    }
}
