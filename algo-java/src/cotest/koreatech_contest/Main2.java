package cotest.koreatech_contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    static int N;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken()) == 0 ? 1 : 0;
                //0이면 길, 1이면 벽으로 내가 바꿈.
            }
        }

        if(board[0][0] == 1) {
            System.out.println(-1);
            System.exit(0);
        }

        int result = bfs(0, 0);

        if(result == -1){
            System.out.println(-1);
        }else{
            System.out.println(calculateAnswer(result));
        }
    }
    static int bfs(int startX, int startY){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        board[startX][startY] = 1; //시작점

        while(!q.isEmpty()){
            int[] current = q.poll();
            int currentX = current[0];
            int currentY = current[1];
            if(currentX == N - 1 && currentY == N - 1){
                return board[currentX][currentY];
            }

            for(int i = 0; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                if(board[nextX][nextY] == 0){
                    board[nextX][nextY] = board[currentX][currentY] + 1;
                    q.offer(new int[]{nextX, nextY});
                }
            }
        }

        return -1; //도달 못함.
    }

    static int calculateAnswer(int walking){
        int pointer = 1;
        int count = 0;
        int resultCount = 0;

        while(pointer != walking){
            if(count == 2){
                count = 0;
                pointer--;
                resultCount++;
            }
            pointer++;
            count++;
            resultCount++;
        }

        return resultCount;
    }
}
