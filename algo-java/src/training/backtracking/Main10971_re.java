package training.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10971_re {
    static int N;
    static int[][] board;
    static boolean[] visited;
    static int realStart;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        //init
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            visited = new boolean[N];
            realStart = i;
            recursive(i, 0, 0);
        }
        System.out.println(min);

    }
    static void recursive(int start, int m, int sum){
        if(m == N){
            min = Math.min(min, sum);

            return;
        }

        for(int i = 0; i < N; i++){
            if(m == N - 1 && i == realStart && board[start][realStart] != 0){
                recursive(realStart, m + 1, sum + board[start][realStart]);
            }else if(board[start][i] != 0 && !visited[i]){
                visited[start] = true;
                recursive(i, m + 1, sum + board[start][i]);
                visited[start] = false;
            }
        }


    }
}
