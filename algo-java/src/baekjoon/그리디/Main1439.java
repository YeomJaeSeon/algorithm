package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int countZero = 0;
        int countOne = 0;

        char startChar = s.charAt(0);
        if(startChar == '0') countZero++;
        else countOne++;

        if(s.length() > 1){
            for(int i = 1; i < s.length(); i++){
                if(s.charAt(i) != startChar){
                    if(s.charAt(i) == '0') countZero++;
                    else countOne++;
                    startChar = s.charAt(i);
                }
            }

            System.out.println(Math.min(countOne, countZero));
        }else{
            System.out.println(0);
        }

    }
}
