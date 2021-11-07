package training.backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Main6443 {
    static int N;
    static String word;
    static boolean[] visited;
    static int[] result;
    static char[] arr;
    static LinkedHashSet<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            word = br.readLine();
            visited = new boolean[word.length()];
            result = new int[word.length()];
            arr = word.toCharArray();
            list = new LinkedHashSet<>();

            Arrays.sort(arr);

            recursive(0);

            for (String s : list) {
                bw.write(s);
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }
    static void recursive(int m){
        if(m == word.length()){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < m; i++){
                sb.append(arr[result[i]]);
            }

            list.add(sb.toString());
            return;
        }

        for(int i = 0; i < word.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                result[m] = i;

                recursive(m + 1);
                visited[i] = false;
            }
        }
    }
}
