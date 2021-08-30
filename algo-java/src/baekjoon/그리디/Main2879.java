package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2879 {
    static int N;
    static int[] diff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        diff = new int[N];
        int[] input = new int[N];
        int[] output = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            output[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            diff[i] = input[i] - output[i];
        }

        System.out.println(fixIndent());
    }
    static int fixIndent(){
        int count = 0;

        List<List<Integer>> group = new ArrayList<>();
        for(int i = 0; i < N; i++){
            group.add(new ArrayList<>());
        }
        int num = 0;
        int before = 0;
        int after = 0;
        if(diff[0] > 0) before = 1;
        else if(diff[0] == 0) before = 0;
        else before = -1;
        group.get(num).add(diff[0]);

        for(int i = 1; i < diff.length; i++){
            if(diff[i] > 0){
                after = 1;
            }else if(diff[i] == 0){
                after = 0;
            }else{
                after = -1;
            }
            if(before == after){
                group.get(num).add(diff[i]);
            }else{
                num++;
                group.get(num).add(diff[i]);
            }
            before = after;
        }

        for (List<Integer> integers : group) {
            if(integers.size() == 0) break;
            Collections.sort(integers);
            int sum = integers.stream().mapToInt(Integer::intValue).sum();
            while(sum != 0){
                for(int i = 0; i < integers.size(); i++){
                    if(integers.get(i) != 0){
                        if(integers.get(i) > 0){
                            integers.set(i, integers.get(i) - 1);
                        }else{
                            integers.set(i, integers.get(i) + 1);
                        }
                    }
                }
                sum = integers.stream().mapToInt(Integer::intValue).sum();
                count++;
            }
        }

        return count;
    }
}
