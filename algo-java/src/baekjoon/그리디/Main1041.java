package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1041 {
    static long N;
    static int[] arr = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine()); // N

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 6; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 주사위각면의 수
        int[] copyArr = arr.clone();
        Arrays.sort(copyArr); // N == 1에 사용될예정

        // N == 1인경우 예외처리
        if(N == 1){
            int sum = 0;
            for(int i = 0; i < 5; i++){
                sum += copyArr[i];
            }
            System.out.println(sum);
            return;
        }

        long oneSum = copyArr[0]; // 면이 하나만보이는 경우에사용될
        long doubleSum = Long.MAX_VALUE;
        long threeSum = Long.MAX_VALUE;

        //double부터
        for(int i = 1; i < 5; i++){
            doubleSum = Math.min(doubleSum, arr[0] + arr[i]);
        }
        doubleSum = Math.min(doubleSum, arr[1] + arr[2]);
        doubleSum = Math.min(doubleSum, arr[2] + arr[4]);
        doubleSum = Math.min(doubleSum, arr[3] + arr[4]);
        doubleSum = Math.min(doubleSum, arr[3] + arr[1]);
        for(int i = 1; i < 5; i++){
            doubleSum = Math.min(doubleSum, arr[5] + arr[i]);
        }

        //threeSum
        threeSum = Math.min(threeSum, arr[0] + arr[1] + arr[2]);
        threeSum = Math.min(threeSum, arr[0] + arr[2] + arr[4]);
        threeSum = Math.min(threeSum, arr[0] + arr[3] + arr[4]);
        threeSum = Math.min(threeSum, arr[0] + arr[3] + arr[1]);
        threeSum = Math.min(threeSum, arr[5] + arr[1] + arr[2]);
        threeSum = Math.min(threeSum, arr[5] + arr[2] + arr[4]);
        threeSum = Math.min(threeSum, arr[5] + arr[3] + arr[4]);
        threeSum = Math.min(threeSum, arr[5] + arr[3] + arr[1]);

        //면이 하나만보이는경우 주사위개수
        long oneCount = (long) Math.pow(N - 2, 2) * 5 + (N - 2) * 4L;
        // 두개만보이는경우
        long twoCount = (N - 2) * 4L + (N - 1) * 4L;
        // 세개만 보이는경우
        long threeCount = 4;

        long sum = oneCount * oneSum + twoCount * doubleSum + threeCount * threeSum;

        System.out.println(sum);

    }
}

/**
 면이 하나보이는 주사위개수,
 두개보이는 주사위개수
 세개보이는 주사위개수를 알아야함

 그리고 면이 두개보일때 최소합
 면이 세개보일때 최소합을 구해야함

 주어지는 배열의 index에 따라서 주사위 전개도에 값이 정해지는데
 배열의 인덱스에 맞게 최소 두면의합, 세면의합을 찾아내는것이 중요함..

 **/