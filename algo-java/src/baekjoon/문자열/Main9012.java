package baekjoon.문자열;

import java.io.*;
import java.util.Stack;

public class Main9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            Stack<String> stack = new Stack<>();

            for(int j = 0; j < str.length(); j++){
                String word = String.valueOf(str.charAt(j));
                if(!stack.isEmpty()){
                    if(stack.peek().equals("(") && word.equals(")")){
                        stack.pop();
                    }else{
                        stack.push(word);
                    }
                }else{
                    stack.push(word);
                }

            }
            if(stack.isEmpty()) bw.write("YES\n");
            else bw.write("NO\n");
        }

        bw.flush();
        bw.close();
    }
}

/**
 stack자료구조 이용해서 품
 **/