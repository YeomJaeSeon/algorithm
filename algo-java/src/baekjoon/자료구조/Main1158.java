package baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1 4
 * 3 -> 6 -> 2 -> 7 -> 5
 */

public class Main1158 {
    static int N, K;
    static List<Integer> list = new LinkedList<>();
    static List<Integer> result = new ArrayList<>(5001);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++){
            list.add(i);
        }

        Iterator<Integer> it = list.iterator();
        makeYosepus(it);

        System.out.println(makeResultList());

    }
    static void makeYosepus(Iterator<Integer> it){
        int idx = 1;
        while(it.hasNext()){
            if(idx % K == 0){
                result.add(it.next());
                it.remove();
            }
            else it.next();
            idx++;

            if(!it.hasNext()){
                it = list.iterator();
            }
        }
    }
    static String makeResultList(){
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        for(int i = 0; i < result.size() - 1; i++){
            sb.append(result.get(i) + ", ");
        }
        sb.append(result.get(result.size() - 1));
        sb.append(">");

        return sb.toString();
    }
}
