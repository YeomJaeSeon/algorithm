package baekjoon.최단경로;

import java.io.*;
import java.util.*;

class PosAndTime implements Comparable<PosAndTime>{
    private int index;
    private int time;

    public PosAndTime(int index, int time){
        this.index = index;
        this.time = time;
    }

    public int getIndex() {
        return index;
    }

    public int getTime() {
        return time;
    }

    @Override
    public int compareTo(PosAndTime o) {
        return time - o.time;
    }

    @Override
    public String toString() {
        return index+","+time;
    }
}

public class Main13549 {
    static final int F = 100001;
    static final int INF = (int)1e9;
    static int[] d = new int[F];
    static boolean[] visited = new boolean[F];
    static int start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        Arrays.fill(d, INF);

        dijkstra(start);

        System.out.println(d[end]);
    }

    static void dijkstra(int start){
        d[start] = 0;
        PriorityQueue<PosAndTime> pq = new PriorityQueue<>();
        pq.offer(new PosAndTime(start, 0));

        while(!pq.isEmpty()){
            PosAndTime pt = pq.poll();
            int now = pt.getIndex();
            if(now == end) break;
            int dist = pt.getTime();
            if(visited[now]) continue;
            visited[now] = true;

            if(now * 2 > 0 && now * 2 < F){
                int cost = dist + 0; // 순간이동
                if(d[now * 2] > cost){
                    d[now * 2] = cost;
                    pq.offer(new PosAndTime(now * 2, cost));
                }
            }
            if(now - 1 >= 0){
                int cost = dist + 1;
                if(d[now - 1] > cost){
                    d[now - 1] = cost;
                    pq.offer(new PosAndTime(now - 1, cost));
                }
            }
            if(now + 1 < F){
                int cost = dist + 1;
                if(d[now + 1] > cost){
                    d[now + 1] = cost;
                    pq.offer(new PosAndTime(now + 1, cost));
                }
            }
        }
    }
}

/**
  우선순위 큐를 이용해서 time이 작은녀석이 우선순위를 줘서 pq에서poll되는 곳으로 이동.
 pq에서 poll되면 방문한 것임로 다익스트라알고리즘으로품
 **/