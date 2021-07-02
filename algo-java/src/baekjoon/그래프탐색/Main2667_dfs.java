package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2667_dfs {
    static List<Integer> list = new ArrayList<>();
    static int homeCount;
    static int N;
    static int[][] board;
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

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                dfs(i, j);
                if(homeCount != 0) list.add(homeCount); // 탐색시작한 곳이 1인곳 추가
                homeCount = 0;
            }
        }
        System.out.println(list.size());
        list.stream().sorted().forEach(System.out::println);

    }
    static void dfs(int x, int y){
        if(board[x][y] == 0) return;
        board[x][y] = 0;
        homeCount++;

        for(int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
            if(board[nextX][nextY] == 0) continue;
            dfs(nextX, nextY);
        }
    }
}

/**
 dfs풀기
 재귀함수를 이용함.
 따로 방문 배열을 만들지말고 board를 이용, 0으로 바꾸면 방문한것으로 만들자

 **/