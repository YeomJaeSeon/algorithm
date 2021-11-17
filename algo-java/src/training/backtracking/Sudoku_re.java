package training.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sudoku_re {
    static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 9; j++){
                int value = Integer.parseInt(st.nextToken());
                board[i][j] = value;
            }
        }

        recursive(0);

    }
    static void recursive(int m){
        if(m == 81){
            printBoard();
            //끝
            System.exit(0);
        }


        int x = m / 9;
        int y = m % 9;

        if(board[x][y] != 0) {
            recursive(m + 1);
        }else{
            for (int j = 1; j <= 9; j++) {
                board[x][y] = j;
                if (!isValid(x, y)) {
                    board[x][y] = 0;
                    continue;
                }
                recursive(m + 1);
                board[x][y] = 0;
            }
        }
    }
    static boolean isValid(int x, int y){
        for(int i = 0; i < 9; i++){
            if(i == y) continue;
            if(board[x][i] == board[x][y]) return false;
        }
        for(int i = 0; i < 9; i++){
            if(i == x) continue;
            if(board[i][y] == board[x][y]) return false;
        }


        int newX = (x / 3) * 3;
        int newY = (y / 3) * 3;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(newX + i == x && newY + j == y) continue;
                if(board[newX + i][newY + j] == board[x][y]) return false;
            }
        }

        return true;
    }
    static void printBoard(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
