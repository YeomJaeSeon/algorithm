package baekjoon.BS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2110_re {
    static int N, C;
    static int[] homes;
    static int[] diffs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        homes = new int[N];
        for(int i = 0; i < N; i++){
            homes[i] = Integer.parseInt(br.readLine());
        }

        int diff = 1;
        while(true){
            for(int i = 0; i < N; i++){
            }
        }

    }
}

/**
 x이상일수있나?
 x이상일수 없나?
 이진탐색..
 **/