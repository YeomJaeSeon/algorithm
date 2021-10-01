package restudy_1.algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3107 {
    static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        if(input.charAt(0) == ':'){
            String[] split = input.split(":");
            int zeroCount = calculateZeroCount(split);

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < zeroCount; i++){
                sb.append("0000:");
            }

            for (String s : split) {
                if(!s.equals("")){
                    int remainLength = 4 - s.length();
                    StringBuilder sub = new StringBuilder();
                    for(int i = 0; i < remainLength; i++)
                        sub.append('0');
                    sub.append(s + ":");
                    sb.append(sub);
                }
            }

            System.out.println(sb.deleteCharAt(sb.length() - 1));
        }else if(input.charAt(input.length() - 1) == ':'){
            String[] split = input.split(":");
            int zeroCount = calculateZeroCount(split);

            StringBuilder sb = new StringBuilder();

            for (String s : split) {
                if(!s.equals("")){
                    int remainLength = 4 - s.length();
                    StringBuilder sub = new StringBuilder();
                    for(int i = 0; i < remainLength; i++)
                        sub.append('0');
                    sub.append(s + ":");
                    sb.append(sub);
                }
            }
            for(int i = 0; i < zeroCount; i++){
                sb.append("0000:");
            }
            System.out.println(sb.deleteCharAt(sb.length() - 1));
        } else{
            String[] split = input.split(":");
            int zeroCount = calculateZeroCount(split);

            StringBuilder sb = new StringBuilder();

            for (String s : split) {
                if(s.equals("")){
                    for(int i = 0; i < zeroCount; i++)
                        sb.append("0000:");
                }else{
                    int remainLength = 4 - s.length();
                    StringBuilder sub = new StringBuilder();
                    for(int i = 0; i < remainLength; i++)
                        sub.append('0');
                    sub.append(s + ":");
                    sb.append(sub);
                }
            }

            System.out.println(sb.deleteCharAt(sb.length() - 1));
        }
    }
    static int calculateZeroCount(String[] split){
        int zeroCount = 0;
        for (String s : split) {
            if(!s.equals("")) zeroCount++;
        }
        zeroCount = 8 - zeroCount; //0으로만 이루어진 개수

        return zeroCount;
    }
}
