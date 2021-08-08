package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main1987 {
    static int R, C; //세로 가로
    static char[][] board;
    static boolean[] visited = new boolean[26];
    static final int ASCII = 65;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Stack<Character> stack = new Stack<>();
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        dfs(0, 0, 0);
        System.out.println(max + 1);
    }
    static void dfs(int x, int y, int count){
        max = Math.max(max, count);
        visited[(int)board[x][y] - ASCII] = true;
        stack.push(board[x][y]);
        board[x][y] = (char)(Integer.parseInt(String.valueOf(count)) + 1 + 48);

        for(int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) continue;
            if((int)board[nextX][nextY] < (int)'A' || (int)'Z' < (int)board[nextX][nextY]) continue; // 대문자 알파벳이 아닐경우
            if(visited[(int)board[nextX][nextY] - ASCII]) continue; // 이미 방문한 대문자 알파벳일경우

            dfs(nextX, nextY, count + 1);
        }
        board[x][y] = stack.pop(); //원상복귀
        visited[(int)board[x][y] - ASCII] = false;
    }
}
