package baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9663_re {
    static int N;
    static int[][] result;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        result = new int[N][N];

        recursive(0, 0);

        System.out.println(count);
    }
    static void recursive(int m, int start){
        if(m == N){
            count++;

            System.out.println();
            print();
            System.out.println();
            return;
        }

        for(int i = start; i < N * N; i++){
            int x = i / N;
            int y = i % N;

            result[x][y] = 1;
            if(!isValid(x, y)) {
                result[x][y] = 0;
                continue;
            }

            recursive(m + 1, i + 1);
            result[x][y] = 0;
        }

    }
    static boolean isValid(int x, int y){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(x == i && y == j) continue;
                if(result[i][j] == 1){
                    if(i == x || j == y || Math.abs(x - i) == Math.abs(y - j))
                        return false;
                }
            }
        }

        return true;
    }
    static void print(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++)
                System.out.print(result[i][j] + " ");
            System.out.println();
        }
    }
}
