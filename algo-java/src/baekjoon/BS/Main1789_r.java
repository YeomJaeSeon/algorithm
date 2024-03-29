package baekjoon.BS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1789_r {
    static long S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Long.parseLong(br.readLine());

        long start = 1;
        long end = S;
        long ans = 0;

        while(start <= end){
            long mid = (start + end) / 2;

            if(mid * (1 + mid) / 2 <= S){
                ans = mid;
                start =  mid + 1;
            }else{
                end = mid - 1;
            }
        }

        System.out.println(ans);

    }
}

/**
 * 1부터 N까지의 합  : N * (N + 1) / 2 - 등차수열의 합
 */