package programmers;

import java.util.Stack;

public class 짝지어_제거하기 {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
    }
    public static int solution(String s)
    {
        int answer = -1;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(!stack.isEmpty()){
                if(stack.peek() == s.charAt(i)){
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
            }else{
                stack.push(s.charAt(i));
            }
        }

        if(stack.isEmpty()){
            answer = 1;
        }else{
            answer = 0;
        }


        return answer;
    }
}

/**
 stack을 이용하면됨
 **/