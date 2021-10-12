package training.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10971_2 {
    static int N;
    static int[][] board;
    static boolean[] visited;
    static int startOrigin;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            //i : 시작하는 도시의 번호
            startOrigin = i;
            recursive(0, i, 0);
        }

        System.out.println(min);
    }
    static void recursive(int m, int startCity, int sum){
        if(m == N){
            min = Math.min(min, sum);

            return;
        }

        for(int i = 0; i < N; i++){
            if(board[startCity][i] != 0 && !visited[i]){

                visited[startCity] = true;
                recursive(m + 1, i,sum + board[startCity][i]); //
                visited[startCity] = false;

            }else if(i == startOrigin && m == N - 1 && board[startCity][startOrigin] != 0){
                recursive(m + 1, i, sum + board[startCity][i]); //
            }
        }
    }
}
