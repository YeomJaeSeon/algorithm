package baekjoon.그리디;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main1343 {
    static String board;
    static List<String> list = new ArrayList<>();

    //AAAA, BB 2가지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = br.readLine();
        String str = "";

        for(int i = 0; i < board.length(); i++){
            if(board.charAt(i) == '.'){
                int length = str.length();
                if(length == 0) continue;
                if(length % 2 != 0){
                    System.out.println(-1);
                    return;
                }
                StringBuilder sb = new StringBuilder();

                while(length >= 4){
                    sb.append("AAAA");
                    length -= 4;
                }
                if(length == 2){
                    sb.append("BB");
                }
                list.add(sb.toString());
                str = "";
                continue;
            }
            str += board.charAt(i);
        }

        if(str.length() > 0 && str.length() % 2 != 0){
            System.out.println(-1);
        }else{
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            while(length >= 4){
                sb.append("AAAA");
                length -= 4;
            }
            if(length == 2){
                sb.append("BB");
            }
            list.add(sb.toString());
        }
        String result = String.join("", list);
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(int i = 0; i < board.length(); i++){
            if(board.charAt(i) == '.'){
                sb.append(".");
            }else{
                sb.append(result.charAt(idx++));
            }
        }
        System.out.println(sb.toString());
    }
}
