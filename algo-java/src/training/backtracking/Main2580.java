package training.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2580 {
    static int[][] board = new int[9][9];
    static List<Set<Integer>> remains = new ArrayList<>();
    static List<Integer> blankPos = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 9; j++){
                int value = Integer.parseInt(st.nextToken());
                if(value == 0) {
                    blankPos.add(i * 9 + j);
                }
                board[i][j] = value;
            }
        }

        for(int i = 0; i < 81; i++){
            remains.add(new HashSet());
            for(int j = 1; j <= 9; j++){
                remains.get(i).add(j);
            }
        }

        for(int i = 0; i < 81; i++){
            int x = i / 9;
            int y = i % 9;

            initRemains(i, x, y);
        }

        recursive(0, 0);

    }
    static void recursive(int m, int start){
        if(m == blankPos.size()){
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        for(int i = start; i < blankPos.size(); i++){
            int x = blankPos.get(i) / 9;
            int y = blankPos.get(i) % 9;

            for (Integer v : remains.get(blankPos.get(i))) {
                board[x][y] = v;
                if(isValid(x, y)){
                    recursive(m + 1, i + 1);
                }
                board[x][y] = 0;
            }
        }
    }

    //해당 보드의 값이 유효한지에 대한 방법으로는 가로, 세로 대각선 중복 숫자 있으면 유효 X
    static boolean isValid(int x, int y){
        int value = board[x][y];

        for(int i = 0; i < 9; i++){
            if(i == y) continue;
            if(board[x][i] == value) return false;
        }

        for(int i = 0; i < 9; i++){
            if(i == x) continue;
            if(board[i][y] == value) return false;
        }

        int vx = x / 3;
        int vy = y / 3;

        vx *= 3;
        vy *= 3;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(vx + i == x && vy + j == y) continue;
                if(board[vx + i][vy + j] == value) return false;
            }
        }

        return true;
    }
    static void initRemains(int num, int x, int y){
        for(int i = 0; i < 9; i++){
            if(board[x][i] != 0){
                remains.get(num).remove(board[x][i]);
            }
            if(board[i][y] != 0){
                remains.get(num).remove(board[i][y]);
            }
        }

        x /= 3;
        y /= 3;

        x *= 3;
        y *= 3;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[x + i][y + j] != 0){
                    remains.get(num).remove(board[x + i][y + j]);
               }
            }
        }
    }
}
