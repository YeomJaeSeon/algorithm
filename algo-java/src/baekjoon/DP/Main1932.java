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
    static List<List<Integer>> dp = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            triangle.add(new ArrayList<>());
            dp.add(new ArrayList<>());
        }
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j <= i; j++){
                triangle.get(i).add(Integer.parseInt(st.nextToken()));
                dp.get(i).add(-1);
            }
        }

        dp.get(0).set(0, triangle.get(0).get(0));

        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < dp.get(i).size(); j++){
                if(dp.get(i + 1).get(j) == -1){
                    dp.get(i + 1).set(j, dp.get(i).get(j) + triangle.get(i + 1).get(j));
                }else{
                    dp.get(i + 1).set(j,
                            Math.max(dp.get(i + 1).get(j), dp.get(i).get(j) + triangle.get(i + 1).get(j))
                    );
                }
                if(dp.get(i + 1).get(j + 1) == -1){
                    dp.get(i + 1).set(j + 1, dp.get(i).get(j) + triangle.get(i + 1).get(j + 1));
                }else{
                    dp.get(i + 1).set(j + 1,
                                Math.max(dp.get(i + 1).get(j + 1), dp.get(i).get(j) + triangle.get(i + 1).get(j + 1))
                            );
                }
            }
        }

        
        System.out.println(Collections.max(dp.get(N - 1)));

    }
}
