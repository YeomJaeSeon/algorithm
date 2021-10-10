package training.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main10 {
    static int N, M;
    static int[] arr;
    static int[] result;
    static Set<String> set = new LinkedHashSet<>();

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

        recursive(0, 0);

        for (String s : set) {
            System.out.println(s);
        }
    }
    static void recursive(int start, int m){
        if(m == M){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < m; i++){
                sb.append(arr[result[i]] + " ");
            }

            set.add(sb.toString());
            return;
        }

        for(int i = start; i < N; i++){
            result[m] = i;
            recursive(i + 1, m + 1);
        }
    }
}
