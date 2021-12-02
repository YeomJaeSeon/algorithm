package baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main1174 {
    static List<Long> resultList = new ArrayList<>();
    static int N;
    static int[] arr = new int[10];
    static int[] result;
    static Stack<Long> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 10; i++){
            arr[i] = 10 - i - 1;
        }

        //1자리수 ~ 10자리수
        for(int i = 1; i <= 10; i++){
            result = new int[i];
            recursive(i, 0, 0);

            while(!stack.isEmpty()){
                resultList.add(stack.pop());
            }

            stack.clear(); //스택 초기화
        }
        N = Integer.parseInt(br.readLine());
        if(N - 1 >= resultList.size()){
            System.out.println(-1);
        }else{
            System.out.println(resultList.get(N - 1));
        }
    }
    static void recursive(int M, int m, int start){
        if(M == m){
            long pow = (long)Math.pow(10, M - 1);
            long sum = 0;
            for(int i = 0; i < M; i++){
                sum += pow * arr[result[i]];
                pow /= 10;
            }
            stack.push(sum);

            return;
        }
        for(int i = start; i < 10; i++){
            result[m] = i;
            recursive(M, m + 1, i + 1);
        }

    }
}
