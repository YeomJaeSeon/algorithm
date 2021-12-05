package baekjoon.BS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10815_r {
    static int N;
    static int[] ns;
    static int M;
    static int[] ms;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ns = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            ns[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        ms = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++){
            ms[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ns); //BS위한 정렬

        for(int i = 0; i < M; i++){
            int target = ms[i];

            int result = binarySearch(target, 0, N - 1);
            if(result == -1)
                System.out.print(0 + " ");
            else
                System.out.print(1 + " ");
        }
    }
    static int binarySearch(int target, int start, int end){
        while(start <= end){
            int mid = (start + end) / 2;

            if(ns[mid] == target){
                return mid;
            }else if(ns[mid] >= target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }

}
