package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1120 {
    static String a, b;
    public static void main(String[] args) throws IOException {
        //A의길이가 B길이보다 작거나같다 3 <= 4
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = st.nextToken();
        b = st.nextToken();
        int sameCount = Integer.MAX_VALUE;

        for(int i = 0; i <= b.length() - a.length(); i++){
            String subB = b.substring(i, i + a.length()); // 변경한 B
            sameCount = Math.min(sameCount, diffCount(a, subB));
        }

        System.out.println(sameCount);

    }
    static int diffCount(String a, String b){
        int count = 0; // 차이 count
        // 두 문자열 length가 같은경우에 이함수호출되도록
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                count++;
            }
        }

        return count;
    }
}

/**
 문제를 처음에 이해를 잘못함.
 a문자열이 b보다 길이가 작거나같음
 굳이 문자열 길이가 같은걸 만들필요가 없이
 최초의 a문자열과 b문자열의 차이가 최소인 subString을 찾기만 하면됨
 아무문자나 앞뒤에 붙여도된다했으니 b랑 같게 무작위로 붙이면됨(우리가 할일 아님)
 단순히 문제는 최소차이를 출력하라했으므로 최초의 a와 b의 substring과의 차이가 최소인
 개수를 찾기만하면됨(같은걸 붙일꺼니 추가되는 차이는 0임..)

 b의 substring을 완전탐색으로 찾음

 **/