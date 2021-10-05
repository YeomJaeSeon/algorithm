package training.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class Main15652_2 {
    static int N, M;
    static int[] result;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[N + 1];

        recursive(0);

        bw.flush();
        bw.close();
    }
    static void recursive(int m) throws IOException {
        if(m == M){
            for(int i = 0; i < M; i++){
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i = (m == 0) ? 1 : result[m - 1]; i <= N; i++){
            result[m] = i;
            recursive(m + 1);
        }
    }
}
