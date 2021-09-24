package restudy_1.algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2468 {
    static int N, maxHeight;
    static int[][] board;
    static int result = 1; //안전영역
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                int height = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, height);
                board[i][j] = height;
            }
        }

        for(int i = 1; i < maxHeight; i++){
            //1부터 maxHeight까지 비가올 경우 모두 생각
            //maxHeight은 안전영역 0개
            int[][] newBoard = new int[N][N];
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    newBoard[j][k] = board[j][k];
                }
            }

            shrink(newBoard, i);
            int count = 0;
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    if(bfs(newBoard, j, k)) ++count;
                }
            }

            result = Math.max(result, count);


        }
        System.out.println(result);

    }
    static void shrink(int[][] board, int rainHeight){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(board[i][j] <= rainHeight){
                    board[i][j] = 0; //잠김
                }
            }
        }
    }
    static boolean bfs(int[][] board, int startX, int startY){
        if(board[startX][startY] == 0) return false;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        board[startX][startY] = 0;

        while(!q.isEmpty()){
            int[] current = q.poll();
            int currentX = current[0];
            int currentY = current[1];

            for(int i = 0; i < 4; i++){
                int nextX = dx[i] + currentX;
                int nextY = dy[i] + currentY;

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                if(board[nextX][nextY] == 0) continue;
                board[nextX][nextY] = board[currentX][currentY] + 1;
                board[nextX][nextY] = 0;
                q.offer(new int[]{nextX, nextY});
            }
        }

        return true;
    }
}
