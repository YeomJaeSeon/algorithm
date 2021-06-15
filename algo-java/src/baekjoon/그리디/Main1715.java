package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main1715 {
    static int N;

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        long sum = 0;
        for(int i = 0; i < N; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        if(pq.size() == 1){
            System.out.println(0);
        }else{
            while(!pq.isEmpty()){
                int x = pq.poll();
                int y = pq.poll();

                sum += (x + y);
                if(pq.isEmpty()) break;
                pq.offer(x + y);
            }
            System.out.println(sum);
        }
    }
}

/**
 카드 비교횟수를 최소로만드는게 목적인 문제이다
 카드 비교횟수를 최소로만드려면
 가장 작은 값들끼리 더해져야한다. 그래야 작은값이 지속되므로
 하나라도 큰수가 더해지면 계속 추가되므로 옳지못함
 즉, 두 묶음을 비교한뒤에도 횟수가 최소인 두묶음을 지속적으로 갱신하며 비교해야함
 우선순위 큐를 이용해서 횟수가 작은녀석을 poll하도록함.

 틀린이유 N == 1이면 0을 출력해야함. 비교횟수가 없으므로..
 **/