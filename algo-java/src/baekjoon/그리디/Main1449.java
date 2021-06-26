package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1449 {
    static int N;
    static int L;
    static int[] waterPoint;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        waterPoint = new int[N];
        StringTokenizer st2= new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            waterPoint[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(waterPoint);
        // 1 2 100 101

        double startPoint = 0;
        double endPoint = 0;
        int count = 0;

        for(int i = 0; i < waterPoint.length; i++){
            if(startPoint == 0){
                startPoint = waterPoint[i] - 0.5;
                endPoint = startPoint + L;
                count++;
            }else{
                if(endPoint - 0.5 >= waterPoint[i]) continue;
                else {
                    startPoint = waterPoint[i] - 0.5;
                    endPoint = startPoint + L;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
