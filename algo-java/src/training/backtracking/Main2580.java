package training.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2580 {
    static int[][] board = new int[9][9];
    static int blankCount;
    static boolean[][] visited = new boolean[81][10];
    static boolean[] check;
    static List<Integer> blankPos = new ArrayList<>();
    // 0 - 1 ~ 9
    // 1 - 1 ~ 9
    // ...
    // 80 - 1 ~ 9

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 9; j++){
                int value = Integer.parseInt(st.nextToken());
                if(value == 0) {
                    blankCount++;
                    blankPos.add(i * 9 + j);
                }
                board[i][j] = value;
            }
        }

        for(int i = 0; i < 81; i++){
            int x = i / 9;
            int y = i % 9;

            initVisited(i, x, y);
        }

        for(int i = 0; i < 81; i++){
            boolean[] booleans = visited[i];
            for(int j = 1; j <= 9; j++){
                System.out.print(booleans[j] + " ");
            }
            System.out.println();
        }


        for (Integer blankPo : blankPos) {
            System.out.println(blankPo);
        }

        System.out.println("blankCount = " + blankCount);
        System.out.println("blankPos = " + blankPos.size());

        check = new boolean[blankCount];

        recursive(0);

    }
//    //유효한지 체크하는 메서드
//    static boolean isValid(int num){
//        for(int i = 1; i <= 9; i++){
//            if(!visited[num][i]) return false;
//        }
//        return true;
//    }
    // 방문배열 초기화
    static void initVisited(int num, int x, int y){
        for(int i = 0; i < 9; i++){
            if(board[x][i] != 0){
                visited[num][board[x][i]] = true;
            }
            if(board[i][y] != 0){
                visited[num][board[i][y]] = true;
            }
        }

        x /= 3;
        y /= 3;

        x *= 3;
        y *= 3;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[x + i][y + j] != 0){
                    visited[num][board[x + i][y + j]] = true;
                }
            }
        }
    }
    static void recursive(int m){
        if(m == blankCount){

            return;
        }

        for(int i = 0; i < blankCount; i++){
            if(!check[i]){
                check[i] = true;
                Integer v = blankPos.get(i);

                int x = v / 9;
                int y = v % 9;

//                visited[v];

                check[i] = false;
            }
        }
    }
}
