package baekjoon.재귀;

import java.io.*;

public class Main11729 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = (int)Math.pow(2, N) - 1;
        bw.write(result +"\n");
        playMove(N, 1, 3, 2);

        bw.flush();
        bw.close();
    }
    static void playMove(int n, int start, int end, int other) throws IOException {
        if(n == 0) return;
        playMove(n - 1, start, other, end);
        bw.write(start + " " + end +"\n");
        playMove(n - 1, other, end, start);
    }
}

/**
 start -> other재귀
 other -> end재귀
 **/