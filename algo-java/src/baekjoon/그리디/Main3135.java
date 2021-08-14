package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main3135 {
    static int A, B, N;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        //A -> B

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        list.add(A);

        Collections.sort(list, Comparator.comparingInt(o -> Math.abs(o - B)));
        if(list.get(0) == A){
            System.out.println(Math.abs(A - B));
        }else{
            if(Math.abs(list.get(0) - B) == Math.abs(A - B))
                System.out.println(Math.abs(list.get(0) - B));
            else
                System.out.println(1 + Math.abs(list.get(0) - B));
        }

    }
}
