package baekjoon.BS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2417 {
    static long N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());

        long start = 0;
        long end = N;
        long answer = 0;

        while(start <= end){
            long mid = (start + end) / 2;

            if(Math.pow(mid, 2) >= N){
                answer = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
