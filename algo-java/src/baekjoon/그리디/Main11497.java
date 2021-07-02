package baekjoon.그리디;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11497 {
    // 최소 난이도 : 인접한 두 통나무의 높이차들의 최대값이 최소가도되록
    // 정렬하면안됨, cycle이므로 첫원소랑 마지막 원소도 인접한걸로 침
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] arr2 = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < N; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            // arr2를 산모양으로 만드는중.
            int cnt = 0;
            for(int j = 0; j < N; j++){
                if(j % 2 == 0){
                    arr2[cnt] = arr[j];
                }else{
                    arr2[N - cnt - 1] = arr[j];
                    cnt++;
                }
            }

            int min = Integer.MIN_VALUE;

            for(int j = 0; j < N; j++){
                if(j == N - 1){
                    min = Math.max(Math.abs(arr2[0] - arr2[N - 1]), min);
                }else{
                    min = Math.max(Math.abs(arr2[j + 1] - arr2[j]), min);
                }
            }

            bw.write(min + "\n");
        }

        bw.flush();
        bw.close();
    }
}

/**
 * 이문제의 핵심은 수열을 산모양으로 만들어야한다.
 * 맨첫원소와 맨끝원소도 인접한걸로 치기때문이다.
 * 그래야 인접 원소끼리의 차의 최대값을 최소로 만들수있다.
 *
 * 그냥 정렬하면 삼각형모양이므로 맨첫원소 맨끝원소의 차가 너무큼.!
 */
