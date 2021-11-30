package baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1935 {
    static int N;
    static double[] alphabets;
    static final int ASCII = 65;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Stack<Double> stack = new Stack<>();

        alphabets = new double[N];
        String expression = br.readLine();

        for(int i = 0; i < N; i++){
            alphabets[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < expression.length(); i++){
            char value = expression.charAt(i);
            if(value >= 'A' && value <= 'Z'){
                //대문자면
                stack.push(alphabets[value - ASCII]);
            }else{
                //수식이면
                double b = stack.pop();
                double a = stack.pop();

                switch (value){
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
