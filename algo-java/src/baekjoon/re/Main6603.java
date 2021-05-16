package baekjoon.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Main6603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String s=  br.readLine();
            if(s.equals("0")) break;
            StringTokenizer st = new StringTokenizer(s, " ");
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[k];
            boolean[] visited =new boolean[k];
            Function<String, Integer> f = Integer::parseInt;
            for(int i = 0; i < k; i++){
                arr[i] = f.apply(st.nextToken());
            }
            combination(0, arr, visited, k, 0);
            System.out.println();
        }
    }
    static void combination(int start, int[] arr, boolean[] visited, int length, int M){
        if(M == 6){
            for(int i = 0; i < length; i++){
                if(visited[i]) System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = start; i < length; i++){
            visited[i] = true;
            combination(i + 1, arr, visited, length, M + 1);
            visited[i] = false;
        }
    }
}
