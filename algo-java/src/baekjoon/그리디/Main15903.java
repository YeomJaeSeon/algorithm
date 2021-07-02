package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main15903 {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            pq.offer(Long.parseLong(st.nextToken()));
        }

        //m번합체
        for(int i = 0; i < m; i++){
            long first = pq.poll();
            long second = pq.poll();
            long sum = first + second;

            pq.offer(sum);
            pq.offer(sum);
        }

        long sum = 0;
        while(!pq.isEmpty()){
            sum += pq.poll();
        }
        System.out.println(sum);
    }
}

/**
 가장 작은수 두개를 더하고 덮어쓰는게 최소합을 나타내는걸 보장함
 우선순위큐를 이용하면 될거라고 쉽게생각이됨

 --- 타입에 주의

 **/