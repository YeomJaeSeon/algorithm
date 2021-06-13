package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main1339 {
    static int N;
    static String[] words;
    static int[] alphabet = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new String[N];
        int maxLength = -1;

        for(int i = 0; i < N; i++){
            words[i] = br.readLine();
            maxLength = Math.max(maxLength, words[i].length());
        }

        Arrays.sort(words, new ArrayAsc());

        char[][] board = new char[N][maxLength];
        int [][] numBoard = new int[N][maxLength];

        for (char[] chars : board) {
            Arrays.fill(chars, 'a');
        }
        for (int[] ints : numBoard) {
            Arrays.fill(ints, -1);
        }
        Arrays.fill(alphabet, -1);

        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                board[i][maxLength - words[i].length() + j] = words[i].charAt(j);
            }
        }

        int value = 9;

        // 대문자 'A' : 아스키코드 65

        for(int i = 0; i < maxLength; i++){
            for(int j = 0; j < N; j++){
                if(board[j][i] != 'a'){
                    if(alphabet[(int)board[j][i] - 65] != -1){
                        numBoard[j][i] = alphabet[(int)board[j][i] - 65];
                    }else{
                        alphabet[(int)board[j][i] - 65] = value;
                        numBoard[j][i] = value;
                        value -= 1;
                    }
                }
            }

        }

        String[] results = new String[N];

        for(int i = 0; i < N; i++){
            String s = "";
            for(int j = 0; j < maxLength; j++){
                if(numBoard[i][j] != -1) s += numBoard[i][j];
            }
            results[i] = s;
        }

        System.out.println(Arrays.stream(results).mapToInt(Integer::parseInt).sum());

    }
}

class ArrayAsc implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return o2.length() - o1.length();
    }

}
