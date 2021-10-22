package cotest.koreatech_contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MainG {
    static int N, Q;
    static Long[] narr;
    static Long[] qarr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        narr = new Long[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            narr[i] = Long.parseLong(st.nextToken());
        }

        Q = Integer.parseInt(br.readLine());
        qarr = new Long[Q];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < Q; i++){
            qarr[i] = Long.parseLong(st.nextToken());
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < Q; i++){
            result.add(new ArrayList<>());
        }

        for(int i = 0; i < N; i++){
            List<Integer> list = new ArrayList<>();
            int v;
            while((v = binarySearch(narr[i])) != -1){
                list.add(v);
            }
            if(list.size() > 0){
                for (Integer integer : list) {
                    System.out.print(integer + " ");
                }
                System.out.println();
            }else{
                System.out.println(-1);
            }
        }
    }
    static int binarySearch(Long target){
        int start = 0;
        int end = Q - 1;

        while (start <= end){
            int mid = (start + end) / 2;
            if(qarr[mid] == target){
                qarr[mid] = -1L;
                return mid + 1;
            }else if(qarr[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return  -1;
    }
}
