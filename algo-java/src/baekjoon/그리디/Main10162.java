package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main10162 {
    static int A, B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        if(T >= 300){
            A = T / 300;
            T = T % 300;
        }
        if(T >= 60){
            B = T / 60;
            T = T % 60;
        }
        if(T >= 10){
            C = T / 10;
            T = T % 10;
        }
        if(T != 0){
            System.out.println(-1);
        }else{
            System.out.println(A + " " + B + " " + C);
        }
    }
}
