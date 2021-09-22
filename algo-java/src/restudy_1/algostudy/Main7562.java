package restudy_1.algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7562 {
    static int T;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            int[][] board = new int[n][n];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            System.out.println(bfs(n, startX, startY, endX, endY, board) - 1); //startX, startY 를 1로시작함.
        }
    }
    static int bfs(int n, int startX, int startY, int endX, int endY, int[][] board){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        board[startX][startY] = 1;

        while(!q.isEmpty()){
            int[] current = q.poll();
            int currentX = current[0];
            int currentY = current[1];
            if(currentX == endX && currentY == endY) {
                return board[currentX][currentY];
            }
            for(int i = 0; i < 8; i++){
                int nextX = dx[i] + currentX;
                int nextY = dy[i] + currentY;

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;
                if(board[nextX][nextY] == 0){
                    board[nextX][nextY] = board[currentX][currentY] + 1;
                    q.offer(new int[]{nextX, nextY});
                }
            }
        }

        return board[endX][endY];
    }
}
