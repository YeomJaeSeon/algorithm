package baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Main17413 {
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        StringBuilder sb = new StringBuilder(str);

        int start = 0;
        int end = 0;
        boolean isWord = true;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '<'){
                for(int j = start; j <= end; j++){
                    System.out.print(str.charAt(j));
                }
                System.out.println();
            }else if(str.charAt(i) == '>'){
                start = i + 1;
            }else if(str.charAt(i) == ' '){
                for(int j = start; j <= end; j++){
                    System.out.print(str.charAt(j));
                }
                System.out.println();

                start = i + 1;
            }else if(i == str.length() - 1){
                for(int j = start; j <= end + 1; j++){
                    System.out.print(str.charAt(j));
                }
                System.out.println();
            }
            else{
                end = i;
            }
        }




    }
}
