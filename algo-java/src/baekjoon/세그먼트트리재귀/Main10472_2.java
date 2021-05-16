package baekjoon.세그먼트트리재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main10472_2 {
    static char[][] result = new char[3][3];
    static int[][] visited = new int[3][3]; // 1, 2 까지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        for(int i = 0; i < P; i++){
            // test start
            for(int j = 0; j < 3; j++){
                String line = br.readLine();
                result[j][0] = line.charAt(0);
                result[j][1] = line.charAt(1);
                result[j][2] = line.charAt(2);
            }
            solve();



        }
    }
    static void solve(){
        System.out.println("solve");
    }
}
