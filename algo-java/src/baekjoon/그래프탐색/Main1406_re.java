package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main1406_re {
    static List<Character> init = new LinkedList<>();
    static String word;
    static int M;
    static int cp;
    static ListIterator<Character> iterator;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        M = Integer.parseInt(br.readLine());
        iterator = init.listIterator();

        for(int i = 0; i < word.length(); i++){
            init.add(word.charAt(i));
            iterator.next();
        }
        for(int i = 0; i < M; i++){
            String cmd = br.readLine();
            command(cmd);
        }
        init.stream().forEach(System.out::print);
    }
    static void command(String cmd){
        if(cmd.length() == 1){
            if(cmd.equals("L")){
                if(cp == 0) return;
                cp--;
            }else if(cmd.equals("D")){
                if(cp == word.length()) return;
                cp++;

            }else if(cmd.equals("B")){
                if(cp == 0) return;
                cp--;
                init.remove(cp);
            }
        }else{
            StringTokenizer st = new StringTokenizer(cmd, " ");
            st.nextToken();
            char word = st.nextToken().charAt(0);

            init.add(cp, word);
            cp++;
        }
    }
}
