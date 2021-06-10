package baekjoon.그리디;

// 3 1 4 3 2 = 13
// 3 4 8 11 13 = 39

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 정렬
// 1 2 3 3 4
// 1 3 6 9 13 = 32(min)
public class Main11399 {
    static int N;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        p = new int[N];
        for(int i = 0; i < N; i++){
            p[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(p);
        for(int i = 1; i < N; i++){
            p[i] += p[i - 1];
        }
        int sum = Arrays.stream(p).sum();
        System.out.println(sum);
    }
}
