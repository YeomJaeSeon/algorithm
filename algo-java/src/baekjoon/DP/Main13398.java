package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main13398 {
    static int n;
    static List<Integer> list = new ArrayList<>();
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        d = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Integer min = list.stream().mapToInt(i -> i).min().getAsInt();
        if(min < 0){
          list.remove(min);
        }
        for(int i = 0; i < n; i++){
            if(list.get(i) > 0){

            }
        }
        System.out.println(list);
    }
}
