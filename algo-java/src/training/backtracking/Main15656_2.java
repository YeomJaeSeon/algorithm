package training.backtracking;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15656_2 {
    static int N, M;
    static int[] arr;
    static int[] result;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

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
        for(int i = 0; i < N; i++){
            result[m] = arr[i];
            recursive(m + 1);
        }
    }
}
