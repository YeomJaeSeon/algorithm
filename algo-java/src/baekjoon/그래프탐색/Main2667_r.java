package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2667_r {
    static int N;
    static int[][] board;
    static int cityCount;
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
                int result = bfs(i, j);
                if(result != 0){
                    cityCount++;
                    houseNumberList.add(result);
                }
            }
        }

        Collections.sort(houseNumberList);
        System.out.println(cityCount);
        for (Integer integer : houseNumberList) {
            System.out.println(integer);
        }
    }
    static int bfs(int x, int y){
        if(board[x][y] == 0) return 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        board[x][y] = 0;

        int count = 1;

        while(!q.isEmpty()){
            int[] poll = q.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            for(int i = 0; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                if(board[nextX][nextY] == 0) continue;
                board[nextX][nextY] = 0;
                q.offer(new int[]{nextX, nextY});
                count++;
            }
        }
        return count;
    }
}
