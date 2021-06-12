package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2210 {
    static int[][] board = new int[5][5];
    static Set<String> set = new HashSet<>(); //6자리수가 들어갈 리스트
    static boolean[][] visited = new boolean[5][5];
    static String tmp = "";
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 5; j++){
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
            }
        }

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                dfs(i, j, stack);
            }
        }

        System.out.println(set);
        System.out.println(stack);

    }
    static void dfs(int x, int y, Stack s){
        if(visited[x][y]) return;

        s.push(board[x][y]);

        if(s.size() == 6){
            set.add(changeToString(s));
            System.out.println(set);
            visited[x][y] = true; // 맨끝에있는거 방문처리
            s.pop();
        }

        for(int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];



            if(nextX < 0 || nextX >= 5 || nextY < 0 || nextY >= 5) continue;
            dfs(nextX, nextY, s);
        }
    }
    static String changeToString(Stack s){
        String str = "";
        for (Object o : s) {
            if(o instanceof Integer){
                Integer i = (Integer) o;
                str += i;
            }
        }
        return str;
    }
}
