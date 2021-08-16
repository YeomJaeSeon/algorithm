package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main3986 {
    static int N;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String word = br.readLine();
            Stack<Character> stack = new Stack<>();
            for(int j = 0; j < word.length(); j++){
                if(!stack.isEmpty()){
                    if(word.charAt(j) == stack.peek()){
                        stack.pop();
                    }else{
                        stack.push(word.charAt(j));
                    }
                }else{
                    stack.push(word.charAt(j));
                }
            }
            if(stack.isEmpty()){
               count++;
            }
        }
        System.out.println(count);
    }
}