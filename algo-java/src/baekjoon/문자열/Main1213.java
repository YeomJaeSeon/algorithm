package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1213 {
    static String name;
    static int[] alphabets = new int[26];
    static final int ASCII = 65;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        name = br.readLine();

        for(int i = 0; i < name.length(); i++){
            alphabets[name.charAt(i) - ASCII]++;
        }
        // 홀수인 원소가 하나만있어야함..
        boolean isPelin = true;
        int oddIdx = -1; // 홀수없음 : -1
        int oddCount = 0;
        for(int i = 0; i < alphabets.length; i++){
            if(alphabets[i] != 0){
                if(alphabets[i] % 2 == 1) {
                    oddCount++;
                    oddIdx = i;
                }
            }
            if(oddCount > 1) {
                isPelin = false;
                break;
            }
        }
        // 펠린드롬 가능여부는 홀수인 알파벳이 두개이상 있으면안됨.
        if(isPelin){
            // 가능
            if(oddIdx == -1){
                //모두 짝수일떄
                StringBuilder sb = new StringBuilder();
                Stack<Character> stack = new Stack<>();

                for(int i = 0; i < alphabets.length; i++){
                    if(alphabets[i] != 0){
                        for(int j = 0; j < alphabets[i] / 2; j++){
                            sb.append((char)(i + ASCII));
                        }
                        for(int j = 0; j < alphabets[i] / 2; j++){
                            stack.push((char)(i + ASCII));
                        }
                    }
                }
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                System.out.println(sb);
            }else{
                //홀수가 하나있을때
                StringBuilder sb = new StringBuilder();
                Stack<Character> stack = new Stack<>();

                for(int i = 0; i < alphabets.length; i++){
                    if(alphabets[i] != 0){
                        for(int j = 0; j < alphabets[i] / 2; j++){
                            sb.append((char)(i + ASCII));
                        }
                        for(int j = 0; j < alphabets[i] / 2; j++){
                            stack.push((char)(i + ASCII));
                        }
                    }
                }
                // 홀수였던 알파벳은 중간에 넣는다.
                sb.append((char)(oddIdx + ASCII));
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                System.out.println(sb);
            }
        }else{
            //불가능
            System.out.println("I'm Sorry Hansoo");
        }
    }
}

/**
 펠린드롬 가능여부는
 모두 짝수이거나
 홀수가 딱하나만있거나 둘중하나의 경우이다.

 펠린드롬을 만들기위해서 알파벳의 개수를 저장할 int배열을 선언했고,
 문자열의 연산이 잦기에 메모리낭비를 막기위해 버퍼를 이용하는 StringBuilder를 이용했고,
 펠린드롬 구현을위해 Stack을 이용함

 사전으로 출력해야하기 때문에, 정수배열 처음부터 펠린드롬을 만들었따.

 틀린이유는 I'm Sorry이부분에 큰따움프룔 추가해서 붙여서.. 얼탱없다.

 **/