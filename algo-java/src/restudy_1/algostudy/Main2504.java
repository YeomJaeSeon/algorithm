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
            //옳은 괄호열임 - 계산해야한다.
            Stack<String> stack = new Stack<>();
            for(int i = 0; i < str.length(); i++){
                if(stack.isEmpty()){
                    stack.push(str.charAt(i) + "");
                    continue;
                }
                if(stack.peek().equals("(")){
                    if(str.charAt(i) == ')'){
                        stack.pop();
                        stack.push("2");
                    }else{
                        stack.push(str.charAt(i)+ "");
                    }
                }else if(stack.peek().equals("[")){
                    if(str.charAt(i) == ']'){
                        stack.pop();
                        stack.push("3");
                    }else{
                        stack.push(str.charAt(i) + "");

                    }
                }else{
                    //스택 맨위에 문자가 숫자일경우

                    if(str.charAt(i) == ']'){
                        int pop = Integer.parseInt(stack.pop());
                        if(isNumber(stack.peek())){
                            //숫자면
                            int number = Integer.parseInt(stack.pop());
                            stack.pop();
                            stack.push(3 * (number + pop) + "");
                        }else{
                            //괄호면
                            stack.pop();
                            stack.push(pop * 3 + "");
                        }
                    }else if(str.charAt(i) == ')'){
                        int pop = Integer.parseInt(stack.pop());
                        if(isNumber(stack.peek())){
                            //숫자면
                            int number = Integer.parseInt(stack.pop());
                            stack.pop();
                            stack.push(2 * (number + pop) + "");
                        }else{
                            //괄호면
                            stack.pop();
                            stack.push(pop * 2 + "");
                        }
                    }else{
                        int pop = Integer.parseInt(stack.pop());
                        if(!stack.isEmpty() && isNumber(stack.peek())){
                            int number = Integer.parseInt(stack.pop());
                            stack.push(number + pop + "");
                        }else{
                            stack.push(pop + "");
                        }

                        stack.push(str.charAt(i) + "");
                    }
                }
            }
            System.out.println(stack.stream().mapToInt(Integer::parseInt).sum());
        }

    }
    static boolean isNumber(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException exception){
            return false;
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
