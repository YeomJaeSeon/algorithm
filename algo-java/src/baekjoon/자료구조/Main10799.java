package baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main10799 {
    static String expression;
    static Stack<Character> stack = new Stack<>();
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        expression = br.readLine();

        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '(')
                stack.push('(');
            else{
                stack.pop();
                if(expression.charAt(i - 1) == '('){
                    //레이저
                    result += stack.size();
                }else{
                    result += 1;
                }
            }
        }

        System.out.println(result);
    }
}
