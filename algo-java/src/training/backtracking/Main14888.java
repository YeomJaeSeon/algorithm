package training.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14888 {
    static int N;
    static int[] arr;
    static int[] operator = new int[4];
    static int M;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        M = Arrays.stream(operator).sum();

        recursive(0, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }
    static void recursive(int m, int sum){
        if(m == M){
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for(int i = 0; i < 4; i++){
            if(operator[i] == 0) continue;
            for(int j = 0; j < operator[i]; j++){
                int s = doSum(i, sum, arr[m + 1]);
                operator[i]--;
                recursive(m + 1, s);
                operator[i]++;
            }
        }
    }
    static int doSum(int i, int sum, int nextValue){
        switch (i){
            case 0:
                sum += nextValue;
                break;
            case 1:
                sum -= nextValue;
                break;
            case 2:
                sum *= nextValue;
                break;
            case 3:
                if(sum < 0){
                    sum *= -1;
                    sum /= nextValue;
                    sum *= -1;
                }else{
                    sum /= nextValue;
                }
                break;
        }

        return sum;
    }
}
