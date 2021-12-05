package baekjoon.BS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1789_r {
    static long S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Long.parseLong(br.readLine());

        int sum = 0;
        for(int i = 1; i <= 19; i++){
            sum += i;
        }
        System.out.println(sum);

    }
}
