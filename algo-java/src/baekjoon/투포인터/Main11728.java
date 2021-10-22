package baekjoon.투포인터;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main11728 {
    static int N, M;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            pq.offer(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++){
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        while(!pq.isEmpty()){
            bw.write(pq.poll() + " ");
        }

        bw.flush();
        bw.close();
    }
}
