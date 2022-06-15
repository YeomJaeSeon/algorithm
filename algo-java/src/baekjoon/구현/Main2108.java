package baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2108 {
    static int N;
    static List<Integer> list = new ArrayList<>();
    static Map<Integer, Integer> map = new HashMap<>();

    static int maxCount = 0;
    static int maxKey = -10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            int value = Integer.parseInt(br.readLine());
            list.add(value);
            if(map.containsKey(value)){
                map.put(value, map.get(value) + 1);
            }else{
                map.put(value, 1);
            }
        }

        Collections.sort(list);

        findMaxCountAndMaxKey();
        List<Integer> maxLists = getMaxCount();

        int sum = list.stream().mapToInt(Integer::intValue).sum();

        if(sum < 0){
            double result = (double)sum / N;
            double value = Math.abs(result);
            System.out.println(Math.round(value) * -1);
        }else{
            System.out.println(Math.round((double)sum / N));
        }
        System.out.println(list.get(N / 2));
        if(maxLists.size() == 1){
            System.out.println(maxLists.get(0));
        }else{
            System.out.println(maxLists.get(1));
        }
        System.out.println(list.get(N - 1) - list.get(0));
    }
    static void findMaxCountAndMaxKey(){
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int value = entry.getValue();
            int key = entry.getKey();
            if(maxCount < value){
                maxCount = value;
                maxKey = key;
            }
        }
    }

    static List<Integer> getMaxCount(){
        List<Integer> maxLists = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            Integer value = entry.getValue();
            if(value == maxCount){
                maxLists.add(entry.getKey());
            }
        }

        Collections.sort(maxLists);

        return maxLists;
    }
}
