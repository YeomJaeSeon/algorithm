package baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10971_r {
    static int N;
    static int[][] board;
    static boolean[] visited;
    static int[] result;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        visited = new boolean[N];
        result = new int[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0);
        System.out.println(min);

    }
    static void recursive(int m){
        if(m == N){
            StringBuilder sb = new StringBuilder();
            int sum = 0;

            for(int i = 0; i < N - 1; i++){
                sum += board[result[i]][result[i + 1]];
            }
            sum += board[result[N - 1]][result[0]];
            min = Math.min(sum, min);

            return;
        }
        for(int i = 0; i < N; i++){
            if(m > 0 && board[result[m - 1]][i] == 0){
                continue;
            }
            if(m == N - 1 && board[i][result[0]] == 0){
                continue;
            }
            if(!visited[i]){
                visited[i] = true;
                result[m] = i;
                recursive(m + 1);
                visited[i] = false;
            }
        }
    }
}
