package baekjoon.그리디;

import java.io.*;

public class Main1343 {
    static String board;

    //AAAA, BB 2가지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = br.readLine();

        StringBuilder sb = new StringBuilder();
        StringBuilder Xsb = new StringBuilder();
        for(int i = 0; i < board.length(); i++){
            if(board.charAt(i) == '.'){
                int length = Xsb.length();
                if(length > 0){
                    if(length % 2 != 0){
                        System.out.println(-1);
                        return;
                    }
                    while(length >= 4){
                        sb.append("AAAA");
                        length -= 4;
                    }
                    if(length == 2){
                        sb.append("BB");
                    }
                }
                sb.append('.');
                Xsb = new StringBuilder();
            }else{
                Xsb.append(board.charAt(i));
            }
        }
        int length = Xsb.length();
        if(length % 2 != 0){
            System.out.println(-1);
            return;
        }
        while(length >= 4){
            sb.append("AAAA");
            length -= 4;
        }
        if(length == 2){
            sb.append("BB");
        }
        System.out.println(sb.toString());

    }
}

/**
 * 문제 자체는 어렵지않음, 2로나누어떨어지지않으면 가능하고
 * 4보다 크면 AAAA만 계쏙채우다가
 * 2남을면 BB채우면 되는문제인데
 * 문자열 조절해서 좀 틀렸음.
 */
