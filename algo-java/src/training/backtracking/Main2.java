package training.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int N, M;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];

        recursive(0, 0);
    }
    static void recursive(int start, int m){
        if(m == M){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < m; i++){
                sb.append(result[i] + " ");
            }
            System.out.println(sb);
            return;
        }
        for(int i = start; i < N; i++){
            result[m] = i + 1;
            recursive(i + 1, m + 1);
        }
    }
}
