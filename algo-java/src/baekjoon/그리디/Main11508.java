package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main11508 {
    static int N;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list, Comparator.reverseOrder());

        System.out.println(calculatePrice());
    }
    static long calculatePrice(){
        long sum = 0;
        for(int i = 0; i < N; i++){
            if(i % 3 == 2) continue;
            sum += list.get(i);
        }
        return sum;
    }
}
