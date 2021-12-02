package baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18430 {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int max = -1;

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

        if(N < 2 && M < 2)
            System.out.println(0);
        else{
            recursive(0, 0);
            System.out.println(max);
        }

    }
    static void recursive(int m, int sum){
        if(m == (N - 1) * (M - 1)){
            max = Math.max(max, sum);
            print();
            return;
        }


        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < M - 1; j++){
                //1
                int x = i;
                int y = j;
                boolean one = false, two = false, three = false, four = false;
                if(!visited[x][y] && !visited[x][y + 1] && !visited[x + 1][y]){
                    one = true;
                    visited[x][y] = true;
                    visited[x][y + 1] = true;
                    visited[x + 1][y] = true;

                    int subSum = board[x][y] * 2 + board[x][y + 1] + board[x + 1][y];

                    recursive(m + 1, sum + subSum);

                    visited[x][y] = false;
                    visited[x][y + 1] = false;
                    visited[x + 1][y] = false;
                }

                //2
                x = i;
                y = j + 1;
                if(!visited[x][y] && !visited[x][y - 1] && !visited[x + 1][y]){
                    two = true;
                    visited[x][y] = true;
                    visited[x][y - 1] = true;
                    visited[x + 1][y] = true;

                    int subSum = board[x][y] * 2 + board[x][y - 1] + board[x + 1][y];

                    recursive(m + 1, sum + subSum);
                    visited[x][y] = false;
                    visited[x][y - 1] = false;
                    visited[x + 1][y] = false;
                }

                //3
                x = i + 1;
                y = j + 1;
                if(!visited[x][y] && !visited[x - 1][y] && !visited[x][y - 1]){
                    three = true;
                    visited[x][y] = true;
                    visited[x - 1][y] = true;
                    visited[x][y - 1] = true;

                    int subSum = board[x][y] * 2 + board[x - 1][y] + board[x][y - 1];
                    recursive(m + 1, sum + subSum);
                    visited[x][y] = false;
                    visited[x - 1][y] = false;
                    visited[x][y - 1] = false;

                }

                //4
                x = i + 1;
                y = j;
                if(!visited[x][y] && !visited[x - 1][y] && !visited[x][y + 1]){
                    four = true;
                    visited[x][y] = true;
                    visited[x - 1][y] = true;
                    visited[x][y + 1] = true;

                    int subSum = board[x][y] * 2 + board[x - 1][y] + board[x][y + 1];

                    recursive(m + 1, sum + subSum);
                    visited[x][y] = false;
                    visited[x - 1][y] = false;
                    visited[x][y + 1] = false;
                }

                if(!one && !two && !three && !four){
                    recursive(m + 1, sum);
                }
            }
        }
    }
    static void print(){
        System.out.println("////==start==////");
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
