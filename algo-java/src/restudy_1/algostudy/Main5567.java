package restudy_1.algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main5567 {
    static int N, M;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        System.out.println(invitePeopleCount());
    }
    static int invitePeopleCount(){
        Set<Integer> set = new HashSet<>();

        for(Integer v : list.get(1)){
            set.add(v); //친구
            set.addAll(list.get(v)); //친구의 친구
        }

        if(set.size() > 0){
            return set.size() - 1; //나 제외하기
        }else{
            return 0;
        }
    }
}
