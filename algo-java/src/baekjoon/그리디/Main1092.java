package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1092 {
    static int N, M;
    static List<Integer> kreins = new ArrayList<>();
    static List<Integer> boxes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            kreins.add(Integer.parseInt(st.nextToken()));
        }
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++){
            boxes.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(kreins);
        Collections.sort(boxes);

        if(kreins.get(N - 1) < boxes.get(M - 1)){
            System.out.println(-1);
        }else{
            System.out.println(calculateTime(makeLiftArr()));
        }

    }
    static int[] makeLiftArr(){
        int[] arr = new int[N];
        for(int i = 0; i < kreins.size(); i++){
            if(i > 0){
                arr[i] = upperBound(kreins.get(i)) - upperBound(kreins.get(i - 1));
            }else{
                arr[i] = upperBound(kreins.get(i));
            }
        }
        return arr;
    }
    static int calculateTime(int[] arr){
        int sum = Arrays.stream(arr).sum();
        int time = 0;
        while(sum > 0){
            for(int i = 0; i < arr.length; i++){
                if(arr[i] != 0){
                    arr[i]--;
                    sum--;
                }else{
                    for(int j = i; j >= 0; j--){
                        if(arr[j] != 0){
                            arr[j]--;
                            sum--;
                            break; // 보다 작은 크레인 에서 박스를 하나 뺏어온뒤 바로 break시켜야함
                        }
                    }
                }
            }
            time++;
        }

        return time;
    }
    static int upperBound(int target){
        int start = 0;
        int end = boxes.size();
        while(start < end){
            int mid = (start + end) / 2;
            if(boxes.get(mid) <= target){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return end;
    }
}
