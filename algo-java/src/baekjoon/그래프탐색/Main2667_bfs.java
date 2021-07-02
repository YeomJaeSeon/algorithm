package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main2667_bfs {
    static int N;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static List<Integer> list = new ArrayList<>();
    static int homeCount;

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
                bfs(i, j);
                if(homeCount != 0) list.add(homeCount);
                homeCount = 0;
            }
        }

        System.out.println(list.size());
        list.stream().sorted().forEach(System.out::println);
    }
    static void bfs(int x, int y){
        if(board[x][y] == 0) return; // 0이면 그냥 return
        Queue<int[]> q = new LinkedList<>(); // bfs를 위한 큐생성
        q.offer(new int[]{x, y});
        board[x][y] = 0;
        homeCount++; // 최초 증가

        while(!q.isEmpty()){
            int[] poll = q.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            for(int i = 0; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                if(board[nextX][nextY] == 0) continue;
                q.offer(new int[]{nextX, nextY});
                board[nextX][nextY] = 0; // 큐에넣으면서 방분처리해야함
                homeCount++; // 방문처리했으니 집개수 증가~
            }
        }
    }
}

/**
 간단한 bfs
 큐에집어넣으면서 방문처리를 해야함 그렇지않고 poll함녀서 방문처리하면 반복된값이 큐에 들어감
 -> 호율성이떨어짐
 **/