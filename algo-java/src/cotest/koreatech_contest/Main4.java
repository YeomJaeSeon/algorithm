package cotest.koreatech_contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main4 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int j = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            for(int k = 0; k < j; k++){
                list.add(Integer.parseInt(st.nextToken()));
            }

            System.out.println(list);
        }
    }
}
