package baekjoon.그리디;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main11501 {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            long[] arr = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++){
                arr[j] = Long.parseLong(st.nextToken());
            }

            long sum = 0;

            Stack<Long> stack = new Stack<>();
            for(int j = n - 1; j >= 0; j--){
                if(stack.isEmpty()){
                    stack.push(arr[j]);
                }else{
                    if(stack.peek() > arr[j]){
                        sum += stack.peek() - arr[j];
                    }else{
                        stack.pop();
                        stack.push(arr[j]);
                    }
                }
            }

            bw.write(sum+"\n");
        }

        bw.flush();
        bw.close();

    }

}

/**
 스택을 이용
 맨뒤의 주가부터 넣으면서 스택에있는것보다 더작은게 나오면 sum에서 더하며(주가를 팔며)
 더 큰게나오면 스택에있는걸 pop하고 다시 push하는식으로함

 **/