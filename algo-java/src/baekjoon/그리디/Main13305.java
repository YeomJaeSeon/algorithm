package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최소의 비용
// 리터당 비용
// 거리의 길이 두개의 정보가나옴
public class Main13305 {
    static int N;
    static int[] dist;
    static int[] price;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dist = new int[N - 1];
        price = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " " );
        for(int i = 0; i < N - 1; i++){
            dist[i] = Integer.parseInt(st.nextToken());
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " " );
        for(int i = 0; i < N; i++){
            price[i] = Integer.parseInt(st2.nextToken());
        }

        long curr = Long.MAX_VALUE;
        long sum = 0;

        for(int i = 0; i < N - 1; i++){
            if(price[i] < curr){
                curr = price[i];
            }
            sum += curr * dist[i];
        }
        System.out.println(sum);
    }
}

/**
 왼쪽부터 오른쪾까지감
 더작으면 curr을 바꿔가면서
 curr비용에 거리만큼을 곱한값을 계속 더한다
 5 2 4 1
 -> 5 2 2로..
 1 1 1 1
 -> 1 1 1

 **/