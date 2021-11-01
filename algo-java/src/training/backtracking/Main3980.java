package training.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3980 {
    static int T;
    static int[][] S;
    static int[] result;
    static boolean[] visited;
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int v = 0; v < T; v++){
            S = new int[11][11];
            result = new int[11];
            visited = new boolean[11];
            max = -1;

            for(int i = 0; i < 11; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < 11; j++){
                    S[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //포지션 11개에 각선수들을 배치하자.

            recursive(0);

            System.out.println(max);
        }
    }
    static void recursive(int m){
        if(m == 11){
            int sum = 0;
            for(int i = 0; i < 11; i++){
                sum += S[result[i]][i];
            }
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < 11; i++){
            if(!visited[i] && S[i][m] != 0){
                visited[i] = true;
                result[m] = i;
                recursive(m + 1);

                visited[i] = false;
            }
        }
    }
}
