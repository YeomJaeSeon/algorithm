package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        //서로 다른 N개의 합이 S일때, N의 최대값을 출력
        // 서로다른 N개의 자연수임
        // 1부터 더해지면될듯
        long sum = 0;
        int i = 1;
        while(sum < S){
            sum += i;
            i++;
        }
        i -= 1;
        if(sum == S){
            System.out.println(i);
            // 더한게 S와같으면 뺼필요없음 1 + 2 + 3 = 6 (if S == 6) 3개
        }else{
            i -= 1;
            System.out.println(i);
            // 더한게 S와 다르면 하나뺴야함 1 + 2 + 3 = 6 (if S == 5)일경우
            // 6에서 1을빼야되므로 개수도 하나뺴야함
        }

    }
}

/**
 그리디
 1부터 더해가면 무조건 S가큼 - 풀이

 틀린이유 40억이넘는 S를 int로받으니 에러남
 sum도 long으로 받아야함
 **/