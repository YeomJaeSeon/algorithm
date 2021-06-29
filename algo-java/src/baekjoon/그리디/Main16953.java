package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16953
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        int cnt = 0;

        while(a < b){
            if(b % 2 == 0){
                b /= 2;
            }else if(b % 10 == 1){
                b /= 10;
            }else{
                System.out.println(-1);
                System.exit(0);
            }
            cnt++;
        }
        if(a == b){
            System.out.println(cnt + 1);
        }else{
            System.out.println(-1);
        }
    }
}

/**
 * 최소연산의 개수라고하지만
 * A를 B로 만든다는건
 * B가 A로부터 만들어졌따.
 * B가 A로부터 만들어질수있냐 없냐를 통해 품
 * 짝수면 2로나누고, 10 나머지가 1이면 10으로 나눔.
 * long으로 타입지정정 */
