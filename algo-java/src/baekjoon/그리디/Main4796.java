package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main4796 {
    static int L, P, V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = 1;
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            if(L == 0 && P == 0 && V == 0) break;

            int rest = V % P > L ? L : V % P;
            int v = V / P;

            System.out.println("Case " + caseNum++ +": " + (rest + v * L));
        }
    }
}

