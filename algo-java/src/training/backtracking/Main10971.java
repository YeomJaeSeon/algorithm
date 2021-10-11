package training.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10971 {
    static int N;
    static int[][] board;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static int start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            visited = new boolean[N];
            start = i; // 시작하는
            recursive(i, 0, 0); //i : 시작하는 도시 번호
        }

        System.out.println(min);
    }
    static void recursive(int n, int m, int subSum){
        if(m == N){
            min = Math.min(min, subSum);
            return;
        }

        for(int i = 0; i < N; i++){
            // 이건 마지막 도시에 탐색했을때 처음 도시까지의 비용을 계산하기 위한 if 문이다. 그 용도만으로 사용됨.
            if(m == N - 1 && start == i && board[n][i] != 0)
                recursive(i, m + 1, subSum + board[n][i]); // 계속해서 시작하는 도시는 업데이트해줘야함 (0, 1) 을 탐색했으면 1로 업데이트해야함
            else if(!visited[i] && board[n][i] != 0){
                visited[n] = true;
                recursive(i, m + 1, subSum + board[n][i]);  // 계속해서 시작하는 도시는 업데이트해줘야함 (0, 1) 을 탐색했으면 1로 업데이트해야함
                visited[n] = false; //탐색이 끝난 도시는 방문처리 다시 초기화해야한다.
            }
        }
    }
}
