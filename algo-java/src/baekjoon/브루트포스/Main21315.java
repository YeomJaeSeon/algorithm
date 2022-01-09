package baekjoon.브루트포스;

//K = 1 ~ 9

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main21315 {
    static int N;
    static int[] result;
    static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        result = new int[N];

        for(int i = 0; i < N ; i++){
            result[i] = Integer.parseInt(st.nextToken());
        }

        //k모든경우
        for(int i = 1; i <= 9; i++){
            for(int j = 1; j <= 9; j++){
                if(playGame(i, j)){
                    a = i;
                    b = j;
                    break;
                }
            }
        }

        System.out.println(a + " " + b);
    }
    static boolean playGame(int first, int second){
        //first -> second
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = i + 1;
        }

        int value = (int)Math.pow(2, first);
        int point = N - 1;

        while(value >= 1){
            int[] tmp = new int[N];
            int start = point - (value - 1);
            for(int i = 0; i < value; i++){
                tmp[i] = arr[start + i];
            }

        }

    }

}
