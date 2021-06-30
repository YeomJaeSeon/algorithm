package baekjoon.BS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//BS 연습
public class Main1920 {
    static int N, M;
    static int[] arrN;
    static int[] arrM;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arrN = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N;i++){
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        arrM = new int[M];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++){
            arrM[i] = Integer.parseInt(st2.nextToken());
        }
        // input ..

        Arrays.sort(arrN); // bs 전에 정렬이되어있어야함.

        for(int i = 0; i < M; i++){
            if(binarySearch(0, N - 1, arrM[i])){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
    static boolean binarySearch(int start, int end, int target){
        while(start <= end){
            int mid = (start + end) / 2;
            if(arrN[mid] == target) return true;
            else if(arrN[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }
}

/**
 N M이 100,000임
 완전탐색풀면 100000^2 임 너무 큼

 BS로풀어야함
 이진탐색으로 풀려면
 정렬이되어있어야하므로 정렬하고

 이진탐색함

 **/