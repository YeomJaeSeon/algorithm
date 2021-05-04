package baekjoon.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// a n t i c 는 무조건 가르쳐야함. 그래야 단어읽을수있다.
public class Main1062 {
    static int N;
    static int K;
    static String[] strArr = new String[50];
    static boolean[] alphabet = new boolean[26];// 가르친 알파벳 기록할 배열
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if(K < 5){
            System.out.println(0);
            System.exit(0);
        }
        if(K == 26){
            System.out.println(N);
            System.exit(0);
        }
        // K가 5 ~ 25개라면. 조합을 생각해야함
        for(int i = 0; i < N; i++){
            strArr[i] = br.readLine();
        }

        // a n t i c는 이미 가르쳤다. 그래야 최대 단어 읽을수있음. 아니 최소 하나라도읽을수있음
        alphabet['a' - 97] = true;
        alphabet['n' - 97] = true;
        alphabet['t' - 97] = true;
        alphabet['c' - 97] = true;
        alphabet['i' - 97] = true;

        K -= 5; // 이미 5개는 가르침 위의것들

        dfs(0, 0);
        System.out.println(max);
    }
    static void dfs(int word, int count){
        if(count == K){
            int teachWord = 0;
            for (String s : strArr) {
                if(s == null) break;
                boolean flag = true;
                for(int i = 0; i < s.length(); i++){
                    if(!alphabet[s.charAt(i) - 97]){
                        flag = false;
                        break;
                    }
                }
                if(flag) teachWord++;
            }
            max = Math.max(max, teachWord);
        }
        //26 C k-5 조합
        for(int i = word; i < 26; i++)
            if(!alphabet[i]){
                alphabet[i] = true;
                dfs(i, count + 1);
                alphabet[i] = false;
            }
    }
}
