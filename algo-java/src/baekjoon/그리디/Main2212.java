package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2212 {
    static int N, K;
    static List<Integer> list = new ArrayList<>();
    static List<Integer> diffList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        diffList = new ArrayList<>(N); //실제값은 N보다 하나 적을 예정

        if(N == 1){
            System.out.println(0);
        }else{
            System.out.println(calculateMinDistance());
        }


    }
    static int calculateMinDistance(){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 1; i < N; i++){
            diffList.add(list.get(i) - list.get(i - 1));
        }

        for(int i = 0; i < diffList.size(); i++){
            pq.offer(diffList.get(i));
        }

        for(int i = 0; i < K - 1; i++){
            pq.poll();
        }

        return pq.stream().mapToInt(i -> i).sum();
    }
}

/**
 * 풀이
 * 어떻게풀어야하나 한참을 고민하던중 센서를 오름차순 정렬한다음에 차이가 가장 적은 부분끼리 K개 분할하면 된다는 문제의
 * 핵심 전략을 파악해버림!!!
 * 그래서 바로 센서의 좌표를 오름차순정렬하고 옆좌표끼리의 차를 다시 diffList라는 ArrayList에 저장함
 * 왜냐면 그중 가장 차이가 큰 K - 1개를 빼야 수신가능한 영역의 합이 최소이므로
 *
 * 직접 여러 예제를 손으로 써가닌까 금방풀림림
*/
