package baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 문자열 길이 1개중 사전순으로 가장앞에오는거 출력
 * 문자열 길이 2개중 사전순으로 가장 앞에오는거 출력
 * 문자열 길이 3개중 사전순으로 가장 앞에오는거 출력
 * ..
 * 문자열 길이 N개중 사전순으로 가장 앞에오는거 출력
 */
public class Main16719 {
    static final int ASCII = 65;
    static String str;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        arr = new int[str.length()];
        visited = new boolean[str.length()];

        for(int i = 0; i < str.length(); i++){
            arr[i] = (int)str.charAt(i) - ASCII;
        }

        System.out.println(Arrays.toString(arr));

        int start = 0;
        while(!isAllVisited()){
            StringBuilder sb = new StringBuilder();
            int smallestIdx = smallestIdxInPartition(start, str.length() - 1);
            visited[smallestIdx] = true;
            start = smallestIdx;

            for(int i = 0; i < str.length(); i++){
                if(visited[i]){
                    sb.append((char)(arr[i] + ASCII));
                }
            }
            System.out.println(sb.toString());
        }

    }
    static boolean isAllVisited(){
        for (boolean isContain : visited) {
            if(!isContain) return false;
        }
        return true;
    }
    static int smallestIdxInPartition(int start, int end){
        int min = 100;
        int idx = -1;
        for(int i = start; i <= end; i++){
            if(visited[i]) continue;
            if(min >= arr[i]){
                min = arr[i];
                idx = i;
            }
        }

        //해당 섹션에 min이 없다면.. 이미 방문다해버렸다면 - 처음부터 확인해야함
        if(idx == -1){
            for(int i = 0; i <= end; i++){
                if(visited[i]) continue;
                if(min >= arr[i]){
                    min = arr[i];
                    idx = i;
                }
            }
        }

        return idx;
    }
}

/**
 * 입력받는 문자열 만큼의 정수 배열이 있어야한다 생각했음
 * 이정수형 배열은 알파벳 대문자의 순서가 있어야한다 생각했음 ( ex A : 0, B : 1, C : 2..)
 * 그리고 적절하기 한개부터 N개씩 뽑으면 된다생각함
 *
 * 어떻게 적절하게?
 * 그게 중요한 뽀인트
 *
 * 풀
 */