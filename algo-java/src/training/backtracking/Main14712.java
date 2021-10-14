package training.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14712 {
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
    

}
