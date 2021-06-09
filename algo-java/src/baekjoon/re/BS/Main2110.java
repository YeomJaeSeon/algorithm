package baekjoon.re.BS;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2110 {
    static int N, C;
    static int[] homes;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        homes = new int[N];
        for(int i = 0; i < N; i++){
            homes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(homes);

        binarySearch(1, homes[N - 1] - homes[0]);

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
    }
    static void binarySearch(int start, int end){
        if(start > end) return;

        int mid = (start + end) / 2;

        int count = install(mid);

        if(count >= C){
            // 설치한 공유기가 더많을때 - 간격을 더 키워볼필요가있음
            answer = Math.max(answer, mid);
            binarySearch(mid + 1, end);
        }else{
            // 설치한 공유기가 더 적을 때 - 간격을 줄여야함
            binarySearch(start, mid - 1);
        }
    }
    static int install(int interval){

        int position = homes[0];
        int count = 1;
        for(int i = 1; i < N; i++){
            if(position + interval <= homes[i]){
                count++;
                position = homes[i];
            }
        }
        return count;
    }
}
