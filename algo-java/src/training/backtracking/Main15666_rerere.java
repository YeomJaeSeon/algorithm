package training.backtracking;

import java.io.*;
import java.util.*;

public class Main15666_rerere {
    static int N, M;
    static int[] arr;
    static int[] result;
    static Set<String> list = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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

        for (String s : list) {
            bw.write(s);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    static void recursive(int m){
        if(m == M){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < m; i++){
                sb.append(arr[result[i]] + " ");
            }

            list.add(sb.toString());

            return;
        }
        for(int i = (m == 0) ? 0 : result[m - 1]; i < N; i++){
            result[m] = i;
            recursive(m + 1);
        }
    }
}
