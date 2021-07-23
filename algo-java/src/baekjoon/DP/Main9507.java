package baekjoon.DP;

import java.io.*;

public class Main9507 {
    static int T;
    static long[] d = new long[70];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        dpSolve();
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            bw.write(d[n] +"\n");
        }
        bw.flush();
        bw.close();
    }
    static void dpSolve(){
        d[0] = 1;
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for(int i = 4; i < 70; i++){
            d[i] = d[i - 1] + d[i - 2] + d[i - 3] + d[i - 4];
        }
    }
}
/**
 귀여운 꿍 문제
 dp를 이용해 dp table에 메모이제이션하면서 바텀업으로 반복문으로 풀면됨
 피보나치랑 같은문제임
 **/