package training.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9663 {
    static int N;
    static int[] result;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N];
        result = new int[N];

        recursive(0);

        System.out.println(count);
    }
    static void recursive(int m){
        if(m == N){

            count++;
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                result[m] = i;
                if(m > 0 && !isValid(m, i)) continue;
                visited[i] = true;

                recursive(m + 1);
                visited[i] = false;
            }
        }
    }
    static boolean isValid(int x, int y){
        for(int i = 0; i < x; i++){
            if(Math.abs(x - i) == Math.abs(y - result[i])) return false;
        }

        return true;
    }
}
