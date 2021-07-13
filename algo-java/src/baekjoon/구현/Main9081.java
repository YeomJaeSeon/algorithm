package baekjoon.구현;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main9081 {
    static String original;
    static int T;
    static char[] result;
    static char[] charArr;
    static boolean[] visited;
    static List<String> list;
    static boolean isRight = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            original = br.readLine();
            charArr = original.toCharArray();
            Arrays.sort(charArr);
            visited = new boolean[charArr.length];
            result = new char[charArr.length];
            list = new ArrayList<>();

            permutations(0, charArr.length);
            System.out.println(list);

            isRight = false;
        }

        bw.flush();
        bw.close();
    }
    static void permutations(int m, int length){
        if(m == length){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < result.length; i++){
                sb.append(result[i]);
            }

            if(!list.contains(sb.toString())) list.add(sb.toString());

            return;
        }
        for(int i = 0; i < length; i++){
            if(!visited[i]){
                visited[i] = true;
                result[m] = charArr[i];
                permutations(m + 1, length);
                visited[i] = false;
            }
        }
    }
}
