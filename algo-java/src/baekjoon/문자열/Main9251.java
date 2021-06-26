package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main9251 {
    static String str1;
    static String str2;
    static int sameIdx;
    static int count;
    static List<Integer> resultList = new ArrayList<>(10000);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        str2 = br.readLine();

        for(int i = 0; i < str1.length(); i++){
            count = 0;
            sameIdx = 0;
            for(int j = i; j < str1.length(); j++){
                for(int k = sameIdx; k < str2.length(); k++){
                    if(str1.charAt(j) == str2.charAt(k)){
                        count++;
                        sameIdx = k + 1;
                        break;
                    }
                }
            }
            resultList.add(count);
        }
        System.out.println(Collections.max(resultList));

    }
}

/**
 ACAYKP
 CAYLLL
 **/