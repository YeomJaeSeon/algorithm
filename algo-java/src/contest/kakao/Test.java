package contest.kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<int[]> result = new ArrayList<>();

        result.add(new int[]{100, 2});
        result.add(new int[]{5, 4});
        result.add(new int[]{10, -10});
        result.add(new int[]{5, -10});

        Collections.sort(result, (o1, o2) -> {
            if(o1[1] != o2[1]){
                return o1[1] - o2[1];
            }else{
                return o1[0] - o2[0];
            }
        });

        for (int[] ints : result) {
            System.out.println(ints[0] + ", " + ints[1]);
        }
    }
}
