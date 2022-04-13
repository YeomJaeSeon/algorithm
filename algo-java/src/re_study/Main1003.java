package re_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1003 {
    static int T;
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 1][2];
            arr[0][0] = 1;

            if(N == 0){
                print(arr[0][0], arr[0][1]);
            }else {
                arr[1][1] = 1;
                if(N == 1){
                    print(arr[1][0], arr[1][1]);
                    continue;
                }
                for(int j = 2; j <= N; j++){
                    arr[j][0] = arr[j - 1][0] + arr[j - 2][0];
                    arr[j][1] = arr[j - 1][1] + arr[j - 2][1];
                }
                print(arr[N][0], arr[N][1]);
            }
        }
    }
    static void print(int a, int b){
        System.out.print(a + " " + b + '\n');
    }
}
