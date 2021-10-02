package koreatech_contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MainF {
    static char[][] board = new char[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                board[i][j] = st.nextToken().charAt(0);
            }
        }

        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 0; j++){
                if(board[i][j] != '.'){

                }
            }
        }


    }
}
