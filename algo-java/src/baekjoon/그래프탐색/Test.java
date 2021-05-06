package baekjoon.그래프탐색;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        System.gc();
        long preUseMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        Map<Integer, Integer> map = new HashMap<>();
        List list = new ArrayList();
        for(int i = 0; i < 100; i++){
            map.put(1, 1);
            list.add(3);
        }

        System.gc();

        long aftUseMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        long useMemory = (preUseMemory - aftUseMemory) / 1000;
        System.out.println(useMemory);
    }
}
