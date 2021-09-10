package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main2193 {
    static int n;
    static List<List<Integer>> dp = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i <= 90; i++){
            dp.add(new ArrayList<>());
        }

        dp.get(0).add(1);
        dp.get(1).add(1);

        dp.get(2).add(1);
        dp.get(2).add(1);

        dp.get(3).add(1);
        dp.get(3).add(2);

        for(int i = 4; i <= 90; i++){
            dp.get(i).add(1);
            for(int j = 1; j < dp.get(i - 1).size(); j++){
                dp.get(i).add(dp.get(i - 1).get(j) + 1);
            }
            if(i % 2 == 0){
                dp.get(i).add(1);
            }
        }

        for (List<Integer> integers : dp) {
            System.out.println(integers);
            System.out.println();
        }

        System.out.println("sum : " + dp.get(n - 1).stream().mapToInt(i -> i).sum());
    }
}
