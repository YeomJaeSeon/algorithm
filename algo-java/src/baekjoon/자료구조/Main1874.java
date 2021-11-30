package baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main1874 {
    static int n;
    static int[] arr;
    static List<Character> resultArr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int value = 1;
        for(int i = 0; i < arr.length; i++){
            while(value <= arr[i]){
                stack.push(value);
                resultArr.add('+');
                value++;
            }
            if(stack.peek() == arr[i]){
                stack.pop();
                resultArr.add('-');
            }else{
                System.out.println("NO");
                System.exit(0);
            }
        }
        for (Character result : resultArr) {
            System.out.println(result);
        }

    }
}

