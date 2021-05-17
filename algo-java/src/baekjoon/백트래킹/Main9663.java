package baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9663 {
    static int N;
    static int cnt = 0;
    static int[] visited2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited2 = new int[N];
        for(int i = 0; i < N; i++)
            visited2[i] = -1;
        solution(0);
        System.out.println(cnt);
    }

    static void solution(int M){
        if(M == N){
            ++cnt;
            return;
        }

        for(int i = 0; i < N; i++){
            if(checkQueen(M, i)) {
                solution(M + 1);
            }
        }
    }

    static boolean checkQueen(int x, int y){
        for(int i = 0; i < x; i++){
            int posx = i;
            int posy = visited2[i];

            if(posx == x || posy == y)
                return false;
            int absX = Math.abs(posx - x);
            int absY = Math.abs(posy - y);
            if(absX == absY)
                return false;
        }
        visited2[x] = y;
        return true;
    }
}
