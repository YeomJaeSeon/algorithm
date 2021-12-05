package baekjoon.BS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2805_r {
    static int N, M;
    static int[] trees;
    static int max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new int[N];
        st =  new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            int height = Integer.parseInt(st.nextToken());
            trees[i] = height;
            max = Math.max(max, height);
        }

        int start = 0;
        int end = max;
        long answer = 0;

        while(start <= end){
            int mid = (start + end) / 2;

            if(calculate(mid) < M){
                end = mid - 1;
            }else{
                answer = mid;
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }
    static long calculate(int mid){
        long sum = 0;
        for (int tree : trees) {
            if(tree > mid){
                sum += (tree - mid);
            }
        }
        return sum;
    }
}
