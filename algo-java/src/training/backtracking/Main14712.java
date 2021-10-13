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

        board = new int[N][M];

        for(int i = 1; i <= N * M; i++){
            recursive(0, i, 0);
        }

        count++; //격자판 위에 넴모가 아무것도 없을경우체크해줌.

        System.out.println(count);
    }
    static void recursive(int m, int maxCnt, int start){
        if(m == maxCnt){
            if(!isExisteNeMo()) count++;

            return;
        }

        for(int i = start; i < N * M; i++){
            board[i / M][i % M] = 1; //네모 넣기
            recursive(m + 1, maxCnt,  i + 1);
            board[i / M][i % M] = 0; //네모 없애기(원복)
        }
    }
    static boolean isExisteNeMo(){
        if(N >= 2 && M >= 2){
            for(int i = 0; i < N - 1; i++){
                for(int j = 0; j < M - 1; j++){
                    if(board[i][j] == 1 &&
                            board[i + 1][j] == 1 &&
                            board[i][j + 1] == 1 &&
                            board[i + 1][j + 1] == 1)
                        return true;
                }
            }
            return false;
        }else{
            return false; //네모 존재 불가
        }
    }
}
