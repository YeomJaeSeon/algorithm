package training.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class Main4 {
    static int N, M;
    static int[] result;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];

        recursive(0, 0);

        bw.flush();
        bw.close();
    }
    static void recursive(int start, int m) throws IOException {
        if(m == M){
            for(int i = 0; i < M; i++){
                bw.write(result[i] + " ");
            }
            bw.write("\n");

            return;
        }

        for(int i = start; i < N; i++){
            result[m] = i + 1;
            if(m == 0){
                recursive(start, m + 1);
            }else{
                recursive(result[m - 1], m + 1);
            }
        }
    }
}
