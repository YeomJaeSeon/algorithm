package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2667_r_dfs {
    static int N;
    static int[][] board;
    static int cityNumber = 0;
    static List<Integer> houseNumberList = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                board[i][j] = str.charAt(j) == '0' ? 0 : 1;
            }
        }

        //단지찾기
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                cityNumber = 0;
                dfs(i, j, 0);
//                print();
                if(cityNumber != 0){
                    houseNumberList.add(cityNumber);
                }
            }
        }

        Collections.sort(houseNumberList);
        System.out.println(houseNumberList.size());
        for (Integer integer : houseNumberList) {
            System.out.println(integer);
        }
    }
    static int dfs(int x, int y, int count){
        if(board[x][y] == 0) return 0;
        board[x][y] = 0;
        cityNumber++;

        for(int i = 0; i < 4; i++){
            int nextX = dx[i] + x;
            int nextY = dy[i] + y;
            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
            if(board[nextX][nextY] == 0) continue;
            dfs(nextX, nextY, count + 1);
        }

        return count;
    }
}
