package baekjoon.DP;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 배낭 문제 알고리즘 - 기본
 */

public class Main12865 {
    static int N, K;
    static List<MyItem> items = new ArrayList<>();
    static int[][] dp = new int[101][100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //무게, 가치 입력들어옴
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            items.add(new MyItem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for(int i = 1; i <= N; i++){
            MyItem item = items.get(i - 1);
            for(int j = 1; j <= K; j++){

                if(item.w > j){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - item.w] + item.v);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}

class MyItem{
    int w, v;

    public MyItem(int w, int v) {
        this.w = w;
        this.v = v;
    }
}
