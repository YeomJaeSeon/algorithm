package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2847 {
    static int N;
    static int[] arr;
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = N - 1; i > 0; i--){
            if(arr[i] <= arr[i - 1]){
                sum += arr[i - 1] - (arr[i] - 1);
                arr[i - 1] = arr[i] - 1;
            }
        }

        System.out.println(sum);
    }
}

/**
 증가하는 수열로 바꾸는 문제임
 입력이 애초에 모두 가능한형태로 들어옴
 맨 마지막 레벨이 제일 높은 점수를 줘야하므로
 배열 뒤에서부터 검색하면서 뒤에값보다 앞에값이 더 크거나 같으면
 앞에값을 뒤에값 - 1로 바꾸어주는 문제임
 그러면서 감소된 점수를 더하면 답임

 그냥 뒤에서부터 비교하면되는문제..
 **/