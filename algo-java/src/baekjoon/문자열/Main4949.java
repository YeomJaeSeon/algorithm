package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            Stack<Character> stack = new Stack<>();

            String sentence = br.readLine();
            if(sentence.equals(".")) break; //종료조건
            boolean isSentence = true;

            for(int i = 0; i < sentence.length(); i++){
                if(sentence.charAt(i) == '(' || sentence.charAt(i) == '['){
                    stack.push(sentence.charAt(i));
                }else{
                    if(sentence.charAt(i) == ')'){
                        if(!stack.isEmpty() && stack.peek() == '('){
                            stack.pop();
                        }else{
                            isSentence = false;
                            break;
                        }
                    }else if(sentence.charAt(i) == ']'){
                        if(!stack.isEmpty() && stack.peek() == '['){
                            stack.pop();
                        }else{
                            isSentence = false;
                            break;
                        }
                    }
                }
            }
            if(!stack.isEmpty()) isSentence = false;

            if(isSentence){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
}

/**
 적절한 괄호문제임
 스택을 이용해서 (거나 [면 스택에 집어넣고
 )거나 ]면 스택 peek()과 비교해서 짝이맞으면 poll하고 짞이맞지않으면
 그대로 적절하지않으므로 break시켜준다.
 너무간단함. 스택의LIFO를 이용

 **/