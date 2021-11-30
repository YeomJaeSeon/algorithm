package baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

class Paper{
    int number;
    int priority;

    public Paper(int number, int priority) {
        this.number = number;
        this.priority = priority;
    }
}

public class Main1966 {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Queue<Paper> q = new LinkedList<>();
            int result = 0;

            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                q.offer(new Paper(j, Integer.parseInt(st.nextToken())));
            }

            for(int j = 0; j < N; j++){
                if(M == solve(q)){
                    result = j + 1;
                    break;
                }
            }
            System.out.println(result);
        }
    }
    static int solve(Queue<Paper> q){
        while(true){
            Paper peek = q.peek();
            long count = q.stream().filter(i -> i.priority > peek.priority).count();
            if(count > 0){
                Paper poll = q.poll();
                q.offer(poll);
            }else{
                return q.poll().number;
            }
        }
    }
}
