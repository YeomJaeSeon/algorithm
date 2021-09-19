package restudy_1.algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3085 {
    static int N;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        System.out.println(change());

    }
    static int change(){
        int max = -1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N - 1; j++){
                //가로 바꾸기
                char tmp = board[i][j];
                board[i][j] = board[i][j + 1];
                board[i][j + 1] = tmp;

                max = Math.max(max, calculateMax());

                //원복
                board[i][j + 1] = board[i][j];
                board[i][j] = tmp;
            }
        }

        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < N; j++){
                //세로 바꾸기
                char tmp = board[i][j];
                board[i][j] = board[i + 1][j];
                board[i + 1][j] = tmp;

                max = Math.max(max, calculateMax());

                //원복
                board[i + 1][j] = board[i][j];
                board[i][j] = tmp;
            }
        }
        return max;
    }
    static int calculateMax(){
        int max = -1;
        //가로 검사
        for(int i = 0; i < N; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < N; j++){
                sb.append(board[i][j]);
            }
            String str = sb.toString();
            max = Math.max(max, inspectOneSentence(str));
        }

        //세로 검사
        for(int i = 0; i < N; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < N; j++){
                sb.append(board[j][i]);
            }
            String str = sb.toString();
            max = Math.max(max, inspectOneSentence(str));
        }

        return max;
    }
    static int inspectOneSentence(String str){
        int max = -1;
        for(int i = 0; i < str.length(); i++){
            char standard = str.charAt(i);
            int count = 0;
            for(int j = i; j < str.length(); j++){
                if(standard == str.charAt(j)) count++;
                else break;
            }
            max = Math.max(count, max);
        }

        return max;
    }
}
