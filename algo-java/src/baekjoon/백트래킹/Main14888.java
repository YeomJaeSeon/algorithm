package baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main14888 {
    static int N;
    static int M;
    static int[] arr;
    static int[] expression = new int[4];
    static List<Integer> expressionList = new ArrayList<>();
    static boolean[] visited;
    static int[] result;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 4; i++){
            expression[i] = Integer.parseInt(st.nextToken());
        }
        M = Arrays.stream(expression).sum();
        visited = new boolean[M];
        result = new int[M];

        for(int i = 0; i < 4; i++){
            int sum = expression[i];
            while(sum > 0) {
                expressionList.add(i);
                sum--;
            }
        }

        recursive(0);

        System.out.println(max);
        System.out.println(min);

    }
    static void recursive(int m){
        if(m == M){
            int sum = arr[0];
            for(int i = 0; i < M; i++){
                switch (expressionList.get(result[i])){
                    case 0:
                        sum = sum + arr[i + 1];
                        break;
                    case 1:
                        sum = sum - arr[i + 1];
                        break;
                    case 2:
                        sum = sum * arr[i + 1];
                        break;
                    case 3:
                        if(arr[i + 1] > 0)
                            sum = sum / arr[i + 1];
                        else
                            sum = (sum / (arr[i + 1] * -1)) * -1;
                        break;
                }
            }
            max = Math.max(sum, max);
            min = Math.min(sum, min);
            return;
        }

        for(int i = 0; i < M; i++){
            if(!visited[i]){
                visited[i] = true;
                result[m] = i;
                recursive(m + 1);
                visited[i] = false;
            }
        }
    }
}
