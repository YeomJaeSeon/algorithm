package koreatech_contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MainH {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String T = st.nextToken();
            String P = st.nextToken();
            //T에서 P를 찾아

            int index = 0;
            List<Integer> indexs = new ArrayList<>();
            while( (index = T.indexOf(P, index)) != -1){
                indexs.add(index);
            }
            System.out.println(indexs.size());
            for (Integer integer : indexs) {
                System.out.println(integer + " ");
            }
            System.out.println();
        }
    }
}
