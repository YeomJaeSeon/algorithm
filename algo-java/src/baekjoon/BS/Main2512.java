package baekjoon.BS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2512 {
    static int N;
    static int[] budgets;
    static int M;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        budgets = new int[N];
        for(int i = 0; i < N; i++){
            budgets[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());

        int sum = Arrays.stream(budgets).sum();
        if(sum <= M){
            System.out.println(Arrays.stream(budgets).max().getAsInt());
        }else{
            //정수 상한액이 필요함.
            //1 ~ M 정수상한액
            int start = 1;
            int end = M;

            while(start <= end){
                int mid = (start + end) / 2;
                int totalPrice = calculatePrice(mid);

                if(totalPrice > M){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                    max = Math.max(max, mid);
                }
            }
            System.out.println(max);
        }

    }
    static int calculatePrice(int mid){
        int sum = 0;
        for(int i = 0; i < N; i++){
            if(budgets[i] > mid){
                sum += mid;
            }else{
                sum += budgets[i];
            }
        }
        return sum;
    }
}
