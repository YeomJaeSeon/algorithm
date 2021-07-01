package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main10773 {
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < K; i++){
            String str = br.readLine();
            if(str.equals("0")) stack.pop();
            else stack.push(str);

        }

        long sum = 0;

        while(!stack.isEmpty()){
            int value = Integer.parseInt(stack.pop());
            sum += value;
        }

        System.out.println(sum);
    }
}

/**
 스택에 문자열을 차곡차곡넣다가
 0이오면 넣지말고 pop하면되는 간단한문제임

 타입 long으로하고, stack의 타입변수를 String으로하는것이 적절

 **/