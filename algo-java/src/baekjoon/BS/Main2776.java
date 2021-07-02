package baekjoon.BS;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2776 {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            //Test Case
            int N = Integer.parseInt(br.readLine());
            int[] paper1 = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " " );
            for(int j = 0; j < N; j++){
                paper1[j] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            int[] paper2 = new int[M];
            st = new StringTokenizer(br.readLine(), " " );
            for(int j = 0; j < M; j++){
                paper2[j] = Integer.parseInt(st.nextToken());
            }
            // 입력받기 끝

            Arrays.sort(paper1); //BS위해

            for(int j = 0; j < M; j++){
                if(binarySearch(0, N - 1, paper1, paper2[j]) == -1){
                    bw.write(0 + "\n");
                }else{
                    bw.write(1 + "\n");
                }
            }

        }
        bw.flush();
        bw.close();
    }
    static int binarySearch(int start, int end, int[] paper1, int target){
        while (start <= end){
            int mid = (start + end) / 2;
            if(paper1[mid] == target) return mid;
            else if(paper1[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return -1;//못찾음
    }
}

/**
 N, M이 최대 100000 이므로
 100000^2는 시간복잡도 너무큼 -> 완전탐색으로 못푼다. 시간제한걸림

 당연하게도 BS를 쓰면됨
 paper1을 정렬하고 이진탐색을 이용함 paper2의 원소 하나하나를 비교하면서.

 너무간단함

 **/