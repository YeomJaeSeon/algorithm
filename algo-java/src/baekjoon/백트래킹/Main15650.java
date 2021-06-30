package baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 조합 dfs
public class Main15650 {
    static int N, M;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        combinations(1, 0);

    }
    static void combinations(int start, int m){
        if(M == m){
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i < N + 1; i++){
                if(visited[i]) sb.append(i + " ");
            }
            System.out.println(sb);
            return;
        }
        for(int i = start; i < N + 1; i++){
            visited[i] = true;
            combinations(i + 1, m + 1);
            visited[i] = false;
        }
    }
}

/**
 조합 - backtracing
 dfs로
 관견은 visited배열

 반복문을사용하는 재귀함수를 이해해야함

 순열과 다른점은 반복문의 시작이 start 한 i + 1이라는것
 중복되지않도록..
 **/