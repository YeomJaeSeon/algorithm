package baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main9012 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            if(isVPS(str)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    static boolean isVPS(String str){
        Stack<Character> stack = new Stack<>();
        stack.push(str.charAt(0));
        for(int i = 1; i < str.length(); i++){
            if(!stack.empty() && stack.peek() == '(' && str.charAt(i) == ')'){
                stack.pop();
                continue;
            }
            stack.push(str.charAt(i));
        }

        if(stack.empty()) return true;
        return false;
    }
}
