package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int s_len = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String pn = "";

        for(int i = 1; i <= 2 * N + 1; i++){
            if(i % 2 == 1) pn += "I";
            else pn += "O";
        }

        int answer = 0;

        // substring으로 똮딲 나눔
//        for(int i = 0; i < s_len - (2 * N + 1); i++){
//            String checkStr = s.substring(i, i + (2 * N + 1));
//            if(checkStr.equals(pn)) answer++;
//            if(!s.substring(i + 1).contains(pn)) {
////                System.out.println("s.substring(i + (2 * N + 1)) = " + s.substring(i + (2 * N + 1)));
////                System.out.println("i = " + i);
//                break;
//            }
//        }

        System.out.println(answer);
    }
}
