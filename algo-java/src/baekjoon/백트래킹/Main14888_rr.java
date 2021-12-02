package baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14888_rr {
    static int N;
    static int[] numbers;
    static int[] expressions = new int[4];
    static boolean[][] visited;
    static int M;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(),  " ");

        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 4; i++){
            expressions[i] = Integer.parseInt(st.nextToken());
        }
        M = Arrays.stream(expressions).sum();
        int maxSize = Arrays.stream(expressions).max().getAsInt();

        visited = new boolean[4][maxSize];

        recursive(0, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }
    static void recursive(int m, int sum){
        if(m == M){
            max = Math.max(sum, max);
            min = Math.min(sum, min);
            return;
        }

        for(int i = 0; i < 4; i++){
            //i : 연산자 종류
            for(int j = 0; j < expressions[i]; j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    int result = calculate(i, sum, m + 1);
                    recursive(m + 1, result);

                    visited[i][j] = false;
                }
            }
        }
    }
    static int calculate(int exp, int sum, int m){
        switch (exp){
            case 0:
              return sum + numbers[m];
            case 1:
                return sum - numbers[m];
            case 2:
                return sum * numbers[m];
            case 3:
                if(numbers[m] < 0){
                    //음수라면
                    return (sum / (numbers[m] * -1)) * -1;
                }else{
                    //양수라면
                    return sum / numbers[m];
                }
        }
        return 100; //
    }
}
