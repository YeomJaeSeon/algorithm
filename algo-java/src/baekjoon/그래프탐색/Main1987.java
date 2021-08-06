package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1987 {
    static int R, C; //세로 가로
    static char[][] board;
    static boolean[] visited = new boolean[26];
    static final int ASCII = 65;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        //input
        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j = 0; j < C; j++){
                board[i][j] = str.charAt(j);
            }
        }
        System.out.println((int)'2');

        System.out.println("bfs(0, 0) = " + bfs(0, 0));

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }
    static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[(int)board[x][y] - ASCII] = true;
        board[x][y] = '1';
        int max = -1;

        while (!q.isEmpty()){
            int[] poll = q.poll();
            int cx = poll[0];
            int cy = poll[1];
            for(int i = 0; i < 4; i++){
                int nextX = cx + dx[i];
                int nextY = cy + dy[i];
                if(nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) continue;
                if((int)board[nextX][nextY] < (int)'A' || (int)'Z' < (int)board[nextX][nextY]) continue; // 대문자 알파벳이 아닐경우
                if(visited[(int)board[nextX][nextY] - ASCII]) continue; // 이미 방문한 대문자 알파벳일경우

                q.offer(new int[]{nextX, nextY});
                board[nextX][nextY] = (char)(Integer.parseInt(String.valueOf(board[cx][cy])) + 1 + 48);
                max = Math.max(max, Integer.parseInt(String.valueOf(board[nextX][nextY])));
            }
            visited[(int)board[nextX][nextY] - ASCII] = true;
        }
        return max;
    }

}
