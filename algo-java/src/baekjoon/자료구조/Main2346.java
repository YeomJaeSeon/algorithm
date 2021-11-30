package baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2346 {
    static int N;
    static List<Integer> list = new LinkedList<>();
    static final int COMPLETE = -1001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        int current = 0;
        int deleteCnt = 0;
        int msg = 0;

        while(true){
            msg = list.get(current);
            list.set(current, COMPLETE);
            sb.append(current + 1 + " ");
            deleteCnt++;

            if(deleteCnt == N) break;

            if(msg > 0){
                //메시지가 양수
                while(msg > 0){
                    current++;
                    if(current == N) current = 0;
                    if(list.get(current) != COMPLETE)
                        msg--;
                }
            }else{
                //메시지가 음수
                while(msg < 0){
                    current--;
                    if(current == -1) current = N - 1;
                    if(list.get(current) != COMPLETE)
                        msg++;
                }
            }
        }
        System.out.println(sb);


    }
}
