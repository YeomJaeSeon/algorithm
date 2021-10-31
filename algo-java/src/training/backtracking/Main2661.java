package training.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2661 {
    static int N;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = new int[N];

        recursive(0);

    }
    static void recursive(int m){
        if(m == N){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < N; i++){
                sb.append(result[i]);
            }
            System.out.println(sb.toString());
            System.exit(0);
        }

        for(int i = 1; i <= 3; i++){
            result[m] = i;
            if (!isValid(m)) { //가지치기
                result[m] = 0;
                continue;
            }

            recursive(m + 1);

            result[m] = 0;
        }
    }
    static boolean isValid(int m){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m + 1; i++){
            sb.append(result[i]);
        }

        String substr = sb.toString();

        // i는 탐색하는 문자열 길이
        for(int i = 1; i < substr.length() + 1; i++){
            if(i > (substr.length() / 2)) break;

            // j : pointer
            for(int j = 0; j < substr.length(); j++){
                if(j + 2 * i > substr.length()) break;
                String str1 = substr.substring(j, j + i);
                String str2 = substr.substring(j + i, j + 2 * i);
                if(str1.equals(str2)) return false;
            }

        }

        return true;
    }
}
