package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] lopes = new int[N];
        for(int i = 0; i < N; i++){
            lopes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lopes);
        for(int i = 0; i < N; i++){
            lopes[i] = lopes[i] * (N - i);
        }
        System.out.println(Arrays.stream(lopes).max().getAsInt());
    }
}

/**
 모든 줄은 같은 중량을 버틸수있음. 분산됨
 오른차순으로 정렬하고,
 제일 작은녀석 * N
 그다음 녀석 * (N - 1)
 ...
 의 최대값을 구혀면됨
 **/