package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 삼각형 : a < b + c
public class Main1448 {
    static int N;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list, Comparator.reverseOrder());
        System.out.println(makeTriangle());
    }
    static int makeTriangle(){
        int sum = -1;
        for(int i = 0; i <= N - 3; i++){
            if(list.get(i) < list.get(i + 1) + list.get(i + 2)){
                sum = list.get(i) + list.get(i + 1) + list.get(i + 2);
                break;
            }
        }
        return sum;
    }
}
