package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Conference implements Comparable<Conference>{

    private int start;
    private int end;

    public Conference(int start, int end){
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public int compareTo(Conference o) {
       if(end - o.end != 0){
           return end - o.end;
       }else{ //끝나는 시간이 같으면
           return start - o.start; // 시작시간을 오름차순으로 정렬해야함.
       }
    }

    @Override
    public String toString() {
        return start + " : " + end;
    }
}

public class Main1931 {
    static int N;
    static Conference[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        p = new Conference[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            p[i] = new Conference(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(p);

        Conference conference = p[0];
        int count = 1;
        for(int i = 1; i < N; i++){
            if(conference.getEnd() <= p[i].getStart()){
                count++;
                conference = p[i];
            }
        }

        System.out.println(count);
    }
}

/**
 회의실 가장 많이 예약하고싶다..
 그러려면 일단 끝나는 시간이 빠른순으로 정렬해야한다 생각했음
 그리고 끝나는 시간과 시작시간을 비교해서 count++해야한다 생각햇음
 그래서 정렬은 간단하게 끝나는 시간순으로 오름차순만함..
 근데 끝나는 시간이 같을 경우 이른 시간순으로 또 오름차순해야하는걸 생각못함...

 틀렸습니다 1
 끝나는 시간이 같을 경우 시작시간은 오름차순으로 정렬해야한다..!!!

 **/