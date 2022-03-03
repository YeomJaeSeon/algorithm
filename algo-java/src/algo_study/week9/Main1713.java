package algo_study.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1713 {
    static int N, M;
    static int[] students = new int[101];
    static int fillCount;
    static List<Integer> times = new ArrayList<>(); //가장 들어간지 오래된 녀석을 뺴기 위해 만든 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < M; i++){
            int vote = Integer.parseInt(st.nextToken());
            if(fillCount == N){
                //이미 다 차있으면
                int deletedIdx = findDeletedIdx(); //가장 작고 가장 오래된 후보
                students[deletedIdx] = 1;
            }

            if(students[vote] == 0){
                fillCount++;
                students[vote]++;
            }else{

            }
        }

    }
}
