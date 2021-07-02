package baekjoon.백트래킹;

import java.io.*;
import java.util.StringTokenizer;

public class Main15652 {
    static int N, M;
    static int[] result;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];

        dfs(0);

        bw.flush();
        bw.close();

    }
    static void dfs(int m) throws IOException{
        if(m == M){
            for(int i = 0; i < M; i++){
                bw.write(result[i] + " ");
            }
            bw.write("\n");

            return;
        }
        for(int i = (m == 0) ? 1 : result[m - 1]; i < N + 1; i++){
            result[m] = i;
            dfs(m + 1);
        }
    }
}

/**
 * 순열인데
 * 이전의 값보다 같거나 커야하므로
 * for문내에서 i를 조작한다.
 * i의 초기값은 이전 result 배열 원소값이다.
 * 만약 m == 0이면 이전값이 없기때무네.. 1을줌
 */

