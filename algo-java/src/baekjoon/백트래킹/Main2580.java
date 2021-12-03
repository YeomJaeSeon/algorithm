package baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2580 {
    static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 9; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0);
    }
    static void recursive(int m){
        if(m == 81){
            printSudoku();

            System.exit(0);
            return;
        }
        int x = m / 9;
        int y = m % 9;

        if(board[x][y] != 0){
            recursive(m + 1);
        }else{
            for(int i = 1; i <= 9; i++){
                board[x][y] = i;

                if(!checkSudoku(x, y)){
                    board[x][y] = 0;
                    continue;
                }

                recursive(m + 1);
                board[x][y] = 0;
            }
        }
    }
    static boolean checkSudoku(int x, int y){
        for(int i = 0; i < 9; i++){
            if(i == x) continue;
            if(board[i][y] == board[x][y]) return false;
        }

        for(int i = 0; i < 9; i++){
            if(i == y) continue;
            if(board[x][i] == board[x][y]) return false;
        }

        int newX = (x / 3) * 3;
        int newY = (y / 3 ) * 3;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(x == newX + i && y == newY + j) continue;
                if(board[newX + i][newY + j] == board[x][y]) return false;
            }
        }

        return true;
    }
    static void printSudoku(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
