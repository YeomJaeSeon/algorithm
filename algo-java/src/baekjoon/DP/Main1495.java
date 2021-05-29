package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1495 {
    // 0 ~ M 볼륨가능
    static int N, S, M;
    static int[] a;
    static int[][] d;
    static boolean isSuccess = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // N, S, M
        N = Integer.parseInt(st.nextToken()); // 곡개수
        S = Integer.parseInt(st.nextToken()); // 시작볼륨
        M = Integer.parseInt(st.nextToken()); // ~ M까지 볼륨키울수있음

        a = new int[N + 1];
        d = new int[N + 1][2];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            a[i] = Integer.parseInt(st2.nextToken());
        }
        System.out.println(Arrays.toString(a));

        d[0][0] = S;
        d[0][1] = S;
        for(int i = 1; i <= N; i++){
            d[i][0] = Math.max(d[i - 1][0] + a[i] <= M ? d[i - 1][0] + a[i] : -1,
                    d[i - 1][1] + a[i] <= M ? d[i - 1][1] + a[i] : -1);
            d[i][1] = Math.max(d[i - 1][0] - a[i] >= 0 ? d[i - 1][0] - a[i] : -1,
                    d[i - 1][1] - a[i] >= 0 ? d[i - 1][1] - a[i] : -1);
            if(d[i][0] == -1 && d[i][1] == -1) {
                isSuccess = false;
                break;
            }
        }

        System.out.println(Arrays.deepToString(d));

        if(!isSuccess){
            System.out.println(-1);
        }else{
            System.out.println(Math.max(d[N][0], d[N][1]));
        }

    }
}
