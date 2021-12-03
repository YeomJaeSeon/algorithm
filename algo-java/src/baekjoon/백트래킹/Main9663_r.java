package baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main9663_r {
    static int N;
    static int[] board;
    static boolean[] visited;
    static int resultCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N];
        visited = new boolean[N];
        Arrays.fill(board, -1); //init

        recursive(0);

        System.out.println(resultCnt);

    }
    static void recursive(int m){
        if(m == N){
            resultCnt++;
            return;
        }

        for(int i = 0; i < N; i++){
            if(!isOk(m, i)){ //가지치기
                continue;
            }

            if(!visited[i]){
                board[m] = i;
                visited[i] = true;

                recursive(m + 1);

                board[m] = -1;
                visited[i] = false;
            }
        }
    }
    static boolean isOk(int x, int y){
        for(int i = 0; i < N; i++){
            if(board[i] == -1) continue;
            if(i == x) continue;
            if(board[i] == board[x]) return false;
            if(Math.abs(x - i) == Math.abs(y - board[i])) return false;
        }

        return true;
    }
}
