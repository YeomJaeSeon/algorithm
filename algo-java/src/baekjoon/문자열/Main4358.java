package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main4358 {
    static int totalCnt;
    static Map<String, Integer> map = new HashMap<>();
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        while(true){
            totalCnt++;
            if(map.containsKey(str)){
                map.put(str, map.get(str) + 1);
            }else{
                map.put(str, 1);
            }
            str = br.readLine();
            if(str == null || str.length() == 0) break;
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();

            double avg = (value / (double)totalCnt) * 100.0;
            String strAvg = String.format("%.4f", avg);
            String result = key + " " + strAvg;
            list.add(result);
        }
        Collections.sort(list);
        list.stream().forEach(System.out::println);
    }
}
