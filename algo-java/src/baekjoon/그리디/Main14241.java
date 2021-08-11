package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main14241 {
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        while (pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            sum += (a * b);
            pq.offer(a + b);
        }
        System.out.println(sum);
    }
}
