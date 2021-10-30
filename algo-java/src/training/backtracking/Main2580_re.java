package training.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2580_re {
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
            display();

            System.exit(0);
        }

        int x = m / 9;
        int y = m % 9;

        if(board[x][y] != 0){
            recursive(m + 1);
        }else{
            for(int i = 1; i <= 9; i++){
                board[x][y] = i;
                if(!isValid(x, y)){
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
            if(y == i) continue;
            if(board[x][y] == board[x][i]) return false;
        }

        for(int i = 0; i < 9; i++){
            if(x == i) continue;
            if(board[x][y] == board[i][y]) return false;
        }
        int newX = x / 3;
        int newY = y / 3;

        newX *= 3;
        newY *= 3;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(x == newX + i && y == newY + j) continue;
                if(board[x][y] == board[newX + i][newY + j]) return false;
            }
        }

        return true;
    }
    static void display(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
