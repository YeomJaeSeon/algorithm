package baekjoon.BS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2805_re {
    static int N;
    static long M;
    static long[] trees;
    static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        trees = new long[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            trees[i] = Integer.parseInt(st2.nextToken());
        }
        long maxLength = Arrays.stream(trees).max().getAsLong();

        binarySearch(0, maxLength);
        System.out.println(result);

    }
    static void binarySearch(long start, long end){
        while(start <= end){
            long mid = (start + end) / 2;
            long total = remainTrees(mid);
            if(total < M){
                end = mid - 1;
            }else{
                result = mid;
                start = mid + 1;
            }
        }
    }
    static long remainTrees(long H){
        long sum = 0;
        for(int i = 0; i < trees.length; i++){
            if(H < trees[i]){
                sum += trees[i] - H;
            }
        }
        return sum;
    }
}
