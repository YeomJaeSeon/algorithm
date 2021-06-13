package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1339_2 {

    static int N;
    static String[] words;
    static int[] alphabets = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new String[N];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++){
                alphabets[str.charAt(j) - 65] += Math.pow(10, str.length() - 1 - j);
            }
        }

        int v = 9;
        int sum = 0;

        Arrays.sort(alphabets);

        for(int i = alphabets.length - 1; i >= 0; i--){
            if(alphabets[i] != 0){
                sum += alphabets[i] * v--;
            }
        }

        System.out.println(sum);

    }
}

/**
 틀린이유
 - 단어를 그냥 길이로 내림차순으로 정렬한뒤
 맨앞에있는 수부터 9부터 줌..
 그런데
 100A , 102B같은 상황이 발생할수있음
 ABB
 BB
 BB
 BB
 BB
 ...
 이런상황엔 A에 9 주는것보다 B에 9주는것이 더큼..
 이상황을 어떻게 해결해야할지 너무고민함.

 풀이
 단어의 문자가 있는 자리수 * 개수가 가장 큰 알파벳에 9부터 수를 부여한다
 위 예에서는
 100A + 11B + 11B + ...
 100A 보다 110B가 더 크다.
 즉, B에 9를 주는 경우가 최대값이다.

 각 단어에 대해서 각 자리에있는 문자의 자리수의 총합이 큰녀석부터 9를 주는게 최대값이다.

 110B + 100A에서 B -> 9
 A -> 8
 을부여하는것이 제일큼
 **/