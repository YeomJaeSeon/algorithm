package baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14712_rr {
    static int N, M;
    static int[][] board;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N + 1][M + 1];

        recursive(0);

        System.out.println(count);
    }

    static void recursive(int m){
        if(m == N * M){
            count++;
            printBoard();
            return;
        }
        int x = m / M + 1;
        int y = m % M + 1;

        if(board[x - 1][y] == 1 && board[x][y - 1] == 1 && board[x - 1][y - 1] == 1)
            recursive(m + 1);
        else{
            recursive(m + 1);
            board[x][y] = 1;
            recursive(m + 1);
            board[x][y] = 0;
        }
    }

    static void printBoard(){
        System.out.println("//=============board=============//");
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("//==========================//");

    }

}
