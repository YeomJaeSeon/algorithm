package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String word = br.readLine();
        int count = 0;

        for(int i = 0; i <= s.length() - word.length(); i++){
            if(s.substring(i, i + word.length()).equals(word)){
                i += (word.length() - 1);
                count++;
            }
        }
        System.out.println(count);


    }
}
/**
 * substring이용해서 찾으면 단어만큼  i += 한다.
 * 틀린이유 for문내에서 반복하므로
 * ++이 계쏙 이루어지기 때문에 += 단어길이한다음
 * 1을 빼야함 어차피 for문자체에서 1이더해지기때문에
 */
