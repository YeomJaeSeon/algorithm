package baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main16987_r {
    static int N;
    static List<MyEgg> eggs = new ArrayList<>();
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            eggs.add(new MyEgg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        recursive(0);

        System.out.println(max);
    }
    static void recursive(int m){
        if(m == N){
            int count = (int)eggs.stream().filter(egg -> egg.dep <= 0).count();
            max = Math.max(max, count);
            return;
        }

        MyEgg handEgg = eggs.get(m);
        if(handEgg.dep <= 0 || brokenCount(m) == N - 1){
            recursive(m + 1);
        }else{
            for(int i = 0; i < N; i++){
                if(i == m) continue; //같은 계란
                if(eggs.get(i).dep <= 0) continue;//깨진 계란 치려할때

                MyEgg targetEgg = eggs.get(i);

                handEgg.dep -= targetEgg.weight;
                targetEgg.dep -= handEgg.weight;

                recursive(m + 1);

                handEgg.dep += targetEgg.weight;
                targetEgg.dep += handEgg.weight;
            }
        }


    }
    static int brokenCount(int currentIdx){
        int count = 0;
        for(int i = 0; i < N; i++){
            if(i == currentIdx) continue;
            if(eggs.get(i).dep <= 0) count++;
        }
        return count;
    }

}
class MyEgg{
    int dep;
    int weight;

    public MyEgg(int dep, int weight) {
        this.dep = dep;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "MyEgg{" +
                "dep=" + dep +
                ", weight=" + weight +
                '}';
    }
}
