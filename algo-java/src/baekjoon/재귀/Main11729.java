package baekjoon.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main11729 {
    static int N;
    static Stack<Integer> st1 = new Stack<>();
    static Stack<Integer> st2 = new Stack<>();
    static Stack<Integer> st3 = new Stack<>();
    static int resultCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        boolean start = true;
        for(int i = N; i >= 1; i--) st1.push(N);
//        for(int i = N; i >= 1; i--) {
//            playMove(i, start);
//            start = !start;
//        }
        playMove(3, true);
    }
    static void playMove(int num, boolean start){
        if(st3.peek() == num) return;
        if(start){
            int value = st1.pop();
            if(value < st3.peek()){
                st3.push(value);
                System.out.println("1 3");
            }else if(value < st2.peek()){
                st2.push(value);
            }
            playMove(num - 1, start);
        }else{
            int value = st1.pop();
            if(value < st2.peek()){
                st2.push(value);
            }else if(value < st3.peek()){
                st3.push(value);
            }
            playMove(num - 1, start);
        }

    }
}
/**
 하노이 재귀함수..
 더생각
 **/