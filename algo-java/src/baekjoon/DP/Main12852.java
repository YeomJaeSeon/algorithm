package baekjoon.DP;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main12852 {
    static int N;
    static int[] d = new int[1000001];
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N + 1; i++) list.add(new ArrayList<>());
        list.get(1).add(1);
        dpSolve();

        bw.write(d[N]+"\n");
        Collections.sort(list.get(N), Comparator.reverseOrder());
        for (Integer integer : list.get(N)) {
            bw.write(integer + " ");
        }

        bw.flush();
        bw.close();
    }
    static void dpSolve(){

        for(int i = 2; i <= N; i++){
            d[i] = d[i - 1] + 1;
            boolean isDivided1 = false;
            boolean isDivided2 = false;

            if(i % 3 == 0 && d[i] > d[i / 3] + 1){
                isDivided1 = true;
                d[i] = d[i / 3] + 1;

            }
            if(i % 2 == 0 && d[i] > d[i / 2] + 1){
                isDivided2 = true;
                d[i] = d[i / 2] + 1;

            }
            if(isDivided2 && !isDivided1){
                for (Integer v : list.get(i / 2)) {
                    list.get(i).add(v);
                }
            }else if(isDivided1 && !isDivided2){
                for (Integer v : list.get(i / 3)) {
                    list.get(i).add(v);
                }
            }else if(!isDivided1 && !isDivided2){
                for (Integer v : list.get(i - 1)) {
                    list.get(i).add(v);
                }
            }
            list.get(i).add(i); // 결과도 넣어야함.
        }
    }
}

/**
 * 현재 i수에 대해서 i - 1 + 1과
 * i / 2 + 1의 횟수와
 * i / 3 + 1의 횟수를 비교하면 된다.
 * dp테이블의 값은 연산의 횟수를 저장하고
 * 바텀업으로 2부터 입력되는 N까지의 수에 대해서 메모이제이션을하자
 * 연산의 방법의 수는 list에 저장하여품
 */