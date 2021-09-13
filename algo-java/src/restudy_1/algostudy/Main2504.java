package restudy_1.algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2504 {
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        if(!isRight()){
            System.out.println(0);
        }else{
            Stack<String> stack = new Stack<>();
            for(int i = 0; i < str.length(); i++){
                if(stack.isEmpty()){
                    stack.push(str.charAt(i) + "");
                }else{
                    if(stack.peek().equals("(")){
                        if(str.charAt(i) == ')'){
                            stack.pop();
                            if(!stack.isEmpty() && (stack.peek().equals("(") || stack.peek().equals("["))){
                                stack.push("2");
                            }else{
                                stack.push(2 + Integer.parseInt(stack.pop()) + "");
                            }
                        }else{
                            stack.push(str.charAt(i) +"");
                        }
                    }else if(stack.peek().equals("[")){
                        if(str.charAt(i) == ']'){
                            stack.pop();
                            if(!stack.isEmpty() && (stack.peek().equals("(") || stack.peek().equals("["))){
                                stack.push("3");
                            }else{
                                stack.push(3 + Integer.parseInt(stack.pop()) + "");
                            }
                        }else{
                            stack.push(str.charAt(i) + "");
                        }
                    }else{
                        //stack.peek() 이 숫자일때,
                        if(str.charAt(i) == ')'){
                            int num = Integer.parseInt(stack.pop());
                            stack.pop();
                            if(!stack.isEmpty() && (stack.peek().equals("(") || stack.peek().equals("["))){
                                stack.push(num * 2 + "");
                            }else{
                                num = Integer.parseInt(stack.pop()) + num * 2;
                                stack.push(num + "");
                            }
                        }else if(str.charAt(i) == ']'){
                            int num = Integer.parseInt(stack.pop());
                            stack.pop();
                            if(!stack.isEmpty() && (stack.peek().equals("(") || stack.peek().equals("["))){
                                stack.push(num * 3 + "");
                            }else{
                                num = Integer.parseInt(stack.pop()) + num * 3;
                                stack.push(num + "");
                            }
                        }else{
                            stack.push(str.charAt(i) + "");
                        }
                    }
                }
            }
            System.out.println(stack);
        }

    }
    static boolean isRight(){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            if(stack.isEmpty()){
                stack.push(str.charAt(i));
            }else{
                if(stack.peek() == '('){
                    if(str.charAt(i) == ')'){
                        stack.pop();
                    }else{
                        stack.push(str.charAt(i));
                    }
                }
                else if(stack.peek() == '['){
                    if(str.charAt(i) == ']'){
                        stack.pop();
                    }else{
                        stack.push(str.charAt(i));
                    }
                }else{
                    stack.push(str.charAt(i));
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
