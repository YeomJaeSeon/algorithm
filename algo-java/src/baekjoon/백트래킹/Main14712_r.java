package baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//넴모를 없앨수 없는 배치의 가지수를 구하는 문제
public class Main14712_r {
    static int N, M;
    static int count;
    static int[][] board;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N * M; i++){
            //i : 넴모 개수
            board = new int[N][M];
            recursive(i, 0, 0);
        }
        System.out.println(count + 1); // 넴모 아무 것도 없는 경우 + 1
    }
    static void recursive(int nemoCnt, int m, int start){
        if(m == nemoCnt){
            count++;
            return;
        }

        for(int i = start; i < N * M; i++){
            int x = i / M;
            int y = i % M;

            board[x][y] = 1;
            if(isNemo()){
                board[x][y] = 0;
                continue;
            }
            recursive(nemoCnt, m + 1, i + 1);
            board[x][y] = 0;
        }
    }
    static boolean isNemo(){
        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < M - 1; j++){
                if(board[i][j] == 1 && board[i + 1][j] == 1 && board[i][j + 1] == 1 && board[i + 1][j + 1] == 1)
                    return true;
            }
        }
        return false;
    }
}
