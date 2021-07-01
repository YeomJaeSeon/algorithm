package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int sum = 0;

        String[] splitStr = str.split("-");
        if(splitStr.length == 1){
            sum = plusCalculate(splitStr[0]);
        }else{
            sum = plusCalculate(splitStr[0]);
            for(int i = 1; i < splitStr.length; i++){
                sum -= plusCalculate(splitStr[i]);
            }
        }
        System.out.println(sum);

    }
    static int plusCalculate(String reg){
        int sum = 0;
        String[] split = reg.split("\\+");
        for(String value : split){
            sum += Integer.parseInt(value);
        }

        return sum;
    }
}

/**
 1. -를 기준으로 split
 String -> String[]로 split

 2. +를 기준으로 split
 String -> String[]

 특수문자를 기준으로 split할때 split("\\+");
 이런식으로 해야한다.
 특수문자 앞에 \\를 두개적는다..

 **/