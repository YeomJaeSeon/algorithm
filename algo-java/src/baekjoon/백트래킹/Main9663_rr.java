package baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main9663_rr {
    static int N;
    static int[] board;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N];
        Arrays.fill(board, -1);

        recursive(0);

        System.out.println(count);
    }
    static void recursive(int m){
        if(m == N){
            count++;
            return;
        }
        for(int i = 0; i < N; i++){
            if(!checkQueen(m, i)) continue;

            board[m] = i;
            recursive(m + 1);
            board[m] = -1;
        }
    }
    static boolean checkQueen(int x, int y){
        for(int i = 0; i < N; i++){
            if(i == x) continue;
            if(board[i] == -1) continue;
            if(board[i] == y) return false;
            if(Math.abs(x - i) == Math.abs(y - board[i])) return false;
        }

        return true;
    }
}
