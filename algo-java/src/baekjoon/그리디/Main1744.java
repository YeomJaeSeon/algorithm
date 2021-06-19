package baekjoon.그리디;

import java.io.*;
import java.util.*;

public class Main1744 {
    static int N;
    static int[] arr;
    /**
     * 길이가 N인 수열
     */
    static List<Integer> minus;
    static List<Integer> plus;

    static List<Integer> tmp = new ArrayList<>(2); // tmp

    static long sum;
    static boolean hasZero;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        minus = new ArrayList<>(N);
        plus = new ArrayList<>(N);

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] == 0) hasZero = true;

        }

        for(int i = 0; i < N; i++){
            if(arr[i] < 0){
                minus.add(arr[i]);
            }else if(arr[i] > 0){
                plus.add(arr[i]);
            }
        }
        Collections.sort(minus);
        Collections.sort(plus, (o1, o2) -> o2 - o1);

        if(!minus.isEmpty()){
            for (Integer v : minus) {
                tmp.add(v);

                if(tmp.size() == 2){
                    sum += (tmp.get(0) * tmp.get(1));

                    tmp.clear();
                }
            }
        }

        // 음수가 남아있으면
        if(!tmp.isEmpty()){

            // 0이있으면 음수 * 0 = 0
            if(hasZero){
                tmp.clear();
            }else{
                // 없으면 그냥 음수 더하고 tmp비우기
                sum += tmp.get(0);
                tmp.clear();
            }
        }

        if(!plus.isEmpty()){
            for (Integer v : plus) {
                if(v == 1){
                    // 1이면 묶는건 더손해임
                    sum += 1;
                    continue;
                }
                tmp.add(v);

                if(tmp.size() == 2){
                    sum += (tmp.get(0) * tmp.get(1));
                    tmp.clear();
                }
            }
        }

        if(!tmp.isEmpty()){
            sum += tmp.get(0);
        }

        System.out.println(sum);

    }
}

/**
 풀이
 간단함
 0 과 1에대해서만 주의하면됨

 1. 음수와 0 둘다있을때 - 곱하는게 최대합임
 2. 1이존재할때, 1은 그냥 더하는게 무조건 더큼

 간과한점
 - 큰값부터 더하는게아닌, 작은값부터더해서 틀림 너무당연한거엿음
 **/