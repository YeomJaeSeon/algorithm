package baekjoon.그리디;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main9009 {
    static int T;
    static int[] d = new int[100];
    static int endIdx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        d[0] = 0;
        d[1] = 1;
        for(int i = 2; i < d.length; i++){
            d[i] = d[i - 2] + d[i - 1];
            if(d[i] > 1000000000){
                endIdx = i;
                break;
            }
        }

        for(int i = 0; i < T; i++){
            int num = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();

            for(int j = endIdx; j >= 0; j--){
                if(num == 0) break;
                if(num >= d[j]){
                    list.add(d[j]);
                    num -= d[j];
                }
            }
            Collections.sort(list);
            for (Integer v : list) {
                bw.write(v + " ");
            }
            bw.write("\n");

        }

        bw.flush();
        bw.close();
    }
}

/**
 dp로 일단 피보나치 결과 저장할 배열만듬
 입력되는 정수가 10억이하이기 때문에 10억 보다 큰녀석이 나오는 즉시 dp테이블 만드는걸 그만둠
 (10억 보다 큰녀석까지 dp테이블에 존재함)

 최소의 개수의 피보나치의 합이 입력되는 정수가 되야한다.
 입력되는 정수보다 가장 근접한(작거나같은) 수를 빼나가면 된다.
 
 **/