package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1092 {
    static List<Integer> list = new ArrayList<>();
    static int N, M;
    static List<Integer> krein = new ArrayList<>();
    static List<Integer> boxes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            krein.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(krein); // 오름차순 정렬

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
           boxes.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(boxes);

        if(boxes.get(M - 1) > krein.get(N - 1)){
            System.out.println(-1);
        }else{
            System.out.println(calculateTime());
        }
    }
    static int calculateTime(){
        for(int i = 0; i < N; i++){
            int count = 0;
            for(int j = 0; j < M; j++){
                if(krein.get(i) >= boxes.get(j)){
                    count++;
                }else break;
            }
            list.add(count);
        }
        System.out.println(list);

        int result = 0;
        int time = 0;
        outer:
        while(list.get(N - 2) > 0){
            for(int i = time; i < N; i++){
                if(list.get(i) > 0){
                    int v = list.get(i) - 1;
                    list.set(i, v);
                    if(time + 1 != N && list.get(N - 2) == 0){
                        result++;
                        break outer;
                    }
                }else break;
            }
            time++;
            if(time == N){
                result++;
                time = 0;
            }
        }
        if(list.get(N - 1) > 0) result += list.get(N - 1);
        return result;
    }
}
