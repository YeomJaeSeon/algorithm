package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main1932 {
    static int N;
    static List<List<Integer>> triangle = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            triangle.add(new ArrayList<>());
        }
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j <= i; j++){
                triangle.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

//        for (List<Integer> integers : triangle) {
//            Collections.fill(integers, -1);
//        }


    }
}
