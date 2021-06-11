package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5585 {
    static int N;
    static int[] p = new int[]{500, 100, 50, 10, 5, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 1000 - Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 0; i < p.length; i++){
            if(N >= p[i]){
                count += (N / p[i]);
                N = N % p[i];
            }
        }
        System.out.println(count);
    }
}
