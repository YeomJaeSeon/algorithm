package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1406 {
    static String init;
    static int M;
    static int cp; // cursor position
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init = br.readLine();
        M = Integer.parseInt(br.readLine());
        cp = init.length(); //

        for(int i = 0; i < M; i++){
            String cmd = br.readLine();
            command(cmd);
        }
        System.out.println(init);
    }
    static void command(String cmd){
        if(cmd.length() == 1){
            if(cmd.equals("L")){
                if(cp == 0) return;
                cp--;
            }else if(cmd.equals("D")){
                if(cp == init.length()) return;
                cp++;

            }else if(cmd.equals("B")){
                if(cp == 0) return;
                cp--;
                init = init.substring(0, cp) + init.substring(cp + 1);
            }
        }else{
            StringTokenizer st = new StringTokenizer(cmd, " ");
            st.nextToken();
            String word = st.nextToken();

            init = init.substring(0, cp) + word + init.substring(cp);
            cp++;
        }
    }
}
