package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Diamond implements Comparable<Diamond>{
    private int M;
    private int V;

    public Diamond(int M, int V){
        this.M = M;
        this.V = V;
    }

    public int getM() {
        return M;
    }

    public int getV() {
        return V;
    }

    public void setM(int m) {
        M = m;
    }

    public void setV(int v) {
        V = v;
    }

    @Override
    public int compareTo(Diamond o) {
        if(M == o.M){
            return o.V - V;
        }
        return M - o.M;
    }

    @Override
    public String toString() {
        return M +","+V;
    }
}

public class Main1202 {
    static int N, K;
    //보석
    static List<Diamond> list = new ArrayList<>(300001);
    static int[] bags;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        long sum = 0;

        for(int i = 0; i < N; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st2.nextToken());
            int V = Integer.parseInt(st2.nextToken());
            list.add(new Diamond(M, V));
        }

        Collections.sort(list);

        bags = new int[K];
        for(int i = 0; i < K; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);

        for(int i = 0, j = 0; i < K; i++){
            while(j < N && list.get(j).getM() <= bags[i]){
                pq.offer(list.get(j++).getV());
            }
            if(!pq.isEmpty()){
                sum += pq.poll();
            }
        }


        System.out.println(sum);
    }
}
