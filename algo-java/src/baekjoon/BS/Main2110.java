package baekjoon.BS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 가장 인접한 두 공유기 사이의 거리는 최대로!
public class Main2110 {
    static int homes[];
    static int N, C;
    static boolean visited[];
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        homes = new int[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++){
            homes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(homes);

        combinations(0, 0);

        System.out.println(max);
    }
    static void combinations(int start, int m){
        if(m == C){
            List<Integer> arr = new ArrayList<>();
            for(int i = 0; i < N; i++){
                if(visited[i]) arr.add(homes[i]);
            }
            int min = arr.get(1) - arr.get(0);

            for(int i = 1; i < C; i++){
                min = Math.min(min, arr.get(i) - arr.get(i - 1));
            }
            max = Math.max(max, min);
            return;
        }
        for(int i = start; i < N; i++){
            visited[i] = true;
            combinations(i + 1, m + 1);
            visited[i] = false;
        }
    }
}
