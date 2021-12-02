package baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main16987_rrr {
    static int max = 0;
    static int N;
    static List<YeomEgg> eggs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            eggs.add(new YeomEgg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        recursive(0);

        System.out.println(max);
    }
    static void recursive(int grab){
        if(grab == N){
            max = Math.max(max, brokenEggsCnt());

            return;
        }
        YeomEgg currEgg = eggs.get(grab);
        if(currEgg.s <= 0 || (currEgg.s > 0 && brokenEggsCnt() == N - 1)){
            recursive(grab + 1);
        }else{
            for(int i = 0; i < N; i++){
                if(i == grab) continue;
                YeomEgg targetEgg = eggs.get(i);
                if(targetEgg.s <= 0) continue;

                 currEgg.s -= targetEgg.w;
                 targetEgg.s -= currEgg.w;

                 recursive(grab + 1);

                 currEgg.s += targetEgg.w;
                 targetEgg.s += currEgg.w;
            }
        }
    }
    static int brokenEggsCnt(){
        return (int)eggs.stream().filter(egg -> egg.s <= 0).count();
    }

}

class YeomEgg{
    int s; //내구도
    int w; //무게

    public YeomEgg(int s, int w) {
        this.s = s;
        this.w = w;
    }
}