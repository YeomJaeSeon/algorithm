package baekjoon.브루트포스;

//K = 1 ~ 9

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main21315 {
    static int N;
    static int[] result;
    static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        result = new int[N];

        for(int i = 0; i < N ; i++){
            result[i] = Integer.parseInt(st.nextToken());
        }
        int max = baseLog(N, 2);
        System.out.println(max);

        //k모든경우
        for(int i = 1; i <= max; i++){
            for(int j = 1; j <= max; j++){
                if(playGame(i, j)){
                    a = i;
                    b = j;
                    break;
                }
            }
        }

        System.out.println(a + " " + b);
    }
    static boolean playGame(int first, int second){
        // first
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = i + 1;
        }

        int value = (int)Math.pow(2, first);
        int part1Start = 0;
        int part1End = (N - 1) - value;
        int part2Start = (N - 1) - value + 1;
        int part2End = N - 1;

        while(value >= 1){
            int[] tmp = new int[N];

            for(int i = 0; i < N; i++){
                tmp[i] = arr[i];
            }

            // part1 <-> part2 swap
            for(int i = part2Start; i <= part2End; i++){
                tmp[i - (part1End - part1Start + 1)] = arr[i];
            }
            for(int i = part1Start; i <= part1End; i++){
                tmp[i + (part2End - part2Start + 1)] = arr[i];
            }

            arr = tmp;
            value = (int)Math.pow(2, --first);
            part1Start = 0;
            part1End = value - 1;
//            part2Start = (N - 1) - value + 1;
//            part2End = N - 1;
        }

        return true;
        // second
    }
    static int baseLog(int x, int base){
        return (int) (Math.log10(x) / Math.log10(base));
    }

}
