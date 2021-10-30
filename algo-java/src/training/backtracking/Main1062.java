package training.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1062 {
    static int N, K;
    static List<String> list = new ArrayList<>();
    static boolean[] visited = new boolean[26];
    static final int ASCII = 97;
    static int max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            String substring = str.substring(4, str.length() - 4);
            list.add(substring);
        }

        if(K < 5){
            System.out.println(0);
        }else{
            initVisited();
            K -= 5;
            recursive(0, 0);
            System.out.println(max);
        }
    }
    static void recursive(int m, int start){
        if(m == K){
            int count = 0;
            for (String str : list) {
                boolean isFull = true;
                for(int i = 0; i < str.length(); i++){
                    if(!visited[(int)str.charAt(i) - ASCII]){
                        isFull = false;
                        break;
                    }
                }
                if(isFull) count++;
            }

            max = Math.max(max, count);
            return;
        }

        for(int i = start; i < 26; i++){
            if(!visited[i]){
                visited[i] = true;
                recursive(m + 1, i + 1);
                visited[i] = false;
            }
        }
    }
    static void initVisited(){
        visited[(int)'a' - ASCII] = true;
        visited[(int)'c' - ASCII] = true;
        visited[(int)'t' - ASCII] = true;
        visited[(int)'i' - ASCII] = true;
        visited[(int)'n' - ASCII] = true;
    }
}
