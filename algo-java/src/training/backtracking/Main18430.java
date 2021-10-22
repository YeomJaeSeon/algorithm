package training.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Boomerang{
    int[] dx;
    int[] dy;

    public Boomerang(int[] dx, int[] dy) {
        this.dx = dx;
        this.dy = dy;
    }
}

public class Main18430 {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int max = -1;
    static List<Boomerang> boomerangs = Arrays.asList(
            new Boomerang(new int[]{0, 0, 1}, new int[]{0, 1, 0}),
            new Boomerang(new int[]{0, 0, 1}, new int[]{1, 0, 1}),
            new Boomerang(new int[]{1, 0, 1}, new int[]{1, 1, 0}),
            new Boomerang(new int[]{1, 1, 0}, new int[]{0, 1, 0})
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(N < 2 || M < 2){
            System.out.println(-1);
            System.exit(1);
        }

        recursive(0, 0, 0);


        System.out.println(max);

    }
    static void recursive(int m, int start, int sum){
        if(m == (N - 1) * (M - 1)){
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < (N - 1) * (M - 1); i++){
            int standardX = i / (M - 1);
            int standardY = i % (M - 1);

            for(int j = 0; j < 4; j++){
                Boomerang boomerang = boomerangs.get(j);

                int shapedX1 = standardX + boomerang.dx[0];
                int shapedY1 = standardY + boomerang.dy[0];

                int shapedX2 = standardX + boomerang.dx[1];
                int shapedY2 = standardY + boomerang.dy[1];

                int shapedX3 = standardX + boomerang.dx[2];
                int shapedY3 = standardY + boomerang.dy[2];

                if(!visited[shapedX1][shapedY1] && !visited[shapedX2][shapedY2] &&
                !visited[shapedX3][shapedY3]){
                    visited[shapedX1][shapedY1] = true;
                    visited[shapedX2][shapedY2] = true;
                    visited[shapedX3][shapedY3] = true;

                    int subSum = board[shapedX1][shapedY1] * 2 +
                            board[shapedX2][shapedY2]
                            + board[shapedX3][shapedY3];

                    recursive(m + 1, i + 1, sum + subSum);

                    visited[shapedX1][shapedY1] = false;
                    visited[shapedX2][shapedY2] = false;
                    visited[shapedX3][shapedY3] = false;
                }else if(j == 3){
                    recursive(m + 1, i + 1,
                            sum);
                }
            }
        }

    }
}
