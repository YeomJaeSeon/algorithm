package baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class MyEgg2{
    int s;
    int w;

    public MyEgg2(int s, int w) {
        this.s = s;
        this.w = w;
    }
}

public class Main16987_rr {
    static int N;
    static List<MyEgg2> eggs = new ArrayList<>();
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            eggs.add(new MyEgg2(Integer.parseInt(st.nextToken()), (Integer.parseInt(st.nextToken()))));
        }

        game(0);

        System.out.println(max);
    }
    static void game(int m){
        if(m == N){
            int count = (int)eggs.stream().filter(egg -> egg.s <= 0).count();

            max = Math.max(max, count);
            return;
        }

        MyEgg2 currentEgg = eggs.get(m);
        if(currentEgg.s <= 0 || brokenCount(m) == N - 1){
            game(m + 1);
        }else{
            for(int i = 0; i < N; i++){
                if(i == m) continue;
                MyEgg2 targetEgg = eggs.get(i);
                if(targetEgg.s <= 0) continue; //깨져있다면

                currentEgg.s -= targetEgg.w;
                targetEgg.s -= currentEgg.w;

                game(m + 1);

                currentEgg.s += targetEgg.w;
                targetEgg.s += currentEgg.w;
            }
        }
    }
    static int brokenCount(int eggNumber){
        int count = 0;
        for(int i = 0; i < N; i++){
            if(i == eggNumber) continue;
            if(eggs.get(i).s <= 0) count++;
        }
        return count;
    }

}
