package cotest.koreatech_contest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] alphabets = new int[26];
    static final int ASCII = 97;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String str = br.readLine();

            for(int j = 0; j < str.length(); j++){
                alphabets[str.charAt(j) - 97]++;
            }
        }

        long count = Arrays.stream(alphabets).filter(i -> i % N != 0).count();

        if(count == 0L){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

    }
}