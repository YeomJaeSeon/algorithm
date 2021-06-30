package baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백트래킹 순열 - dfs로
public class Main15649_re {
    static int N, M;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        result = new int[M];

        permutations(0);

    }
    static void permutations(int m){
        if(M == m){
            StringBuilder sb = new StringBuilder();
            for(int value : result){
                sb.append(value + " " );
            }
            System.out.println(sb);
            return;
        }
        for(int i = 1; i < N + 1; i++){
            if(!visited[i]){
                visited[i] = true;
                result[m] = i;

                permutations(m + 1);
                visited[i] = false;
            }
        }
    }
}

/**
 순열 - dfs
 반복문 + 재귀함수 이해해야함

 조합과 다른점은
 반복문을 무조건 1부터시작하는것,
 자기자신은 방문을 했으니 반복문내에 자기자신 한번더 방문하는것 막는 조건문존재하는것
 조합은 어짜피 -> 방향으로 방문하기에 순서가중요하지않지만
 순열은 순서를 맞춰줘야하므로 하나의 배열을 더 선언한것..

 visited boolean배열과 재귀함수 + 반복문 이용하는 로직은 같음
 **/