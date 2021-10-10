package training.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1182 {
    static int N, S;
    static int[] arr;
    static int[] result;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for(int i = 1; i <= N; i++){
            result = new int[i];
            recursive(0, 0, i, result);
        }

        System.out.println(count);
    }
    static void recursive(int start, int m, int M, int[] result){
        if(m == M){
            int sum = 0;
            for(int i = 0; i < M; i++){
                sum += arr[result[i]];
            }

            if(sum == S) count++;

            return;
        }

        for(int i = start; i < N; i++){
            result[m] = i;
            recursive(i + 1, m + 1, M, result);
        }
    }
}
