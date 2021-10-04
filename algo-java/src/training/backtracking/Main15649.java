package training.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

//== 1 ~ N 수중 중복없이 M개 모두 출력 - (사전 순) ==//
public class Main15649 {
    static int N, M;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        recursive(0);

    }
    static void recursive(int V){
        if(V == M){
            StringBuilder sb = new StringBuilder();
            for (Integer integer : stack) {
                sb.append(integer + 1 + " ");
            }
            System.out.println(sb);
            return;
        }

        for(int i = 0; i < N; i++){
            if(!stack.contains(i)){
                stack.push(i);
                recursive(V + 1);
                stack.pop();
            }
        }
    }
}
