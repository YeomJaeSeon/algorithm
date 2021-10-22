package baekjoon.투포인터;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11728_2 {
    static int N, M;
    static int[] arrA;
    static int[] arrB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arrA = new int[N];
        arrB = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++){
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        int pointerA = 0;
        int pointerB = 0;


        while(pointerA != N && pointerB != M){
            if(arrA[pointerA] >= arrB[pointerB]){
                bw.write(arrB[pointerB++] + " ");
            }else{
                bw.write(arrA[pointerA++] + " ");
            }
        }

        if(N == pointerA){
            for(int i = pointerB; i < M; i++)
                bw.write(arrB[i] + " ");
        }else if(M == pointerB){
            for(int i = pointerA; i < N; i++)
                bw.write(arrA[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}
