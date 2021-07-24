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

            if(i % 3 == 0){
                if(d[i] > d[i / 3] + 1){
                    for (Integer v : list.get(i / 3)) {
                        list.get(i).add(v);
                    }
                    d[i] = d[i / 3] + 1;
                }else{
                    for (Integer v : list.get(i - 1)) {
                        list.get(i).add(v);
                    }
                }
            }else if(N % 2 == 0){
                if(d[i] > d[i / 2] + 1){
                    for (Integer v : list.get(i / 2)) {
                        list.get(i).add(v);
                    }
                    d[i] = d[i / 2] + 1;
                }else{
                    for (Integer v : list.get(i - 1)) {
                        list.get(i).add(v);
                    }
                }
            }
            list.get(i).add(i); // 결과도 넣어야함.
        }
    }
}
