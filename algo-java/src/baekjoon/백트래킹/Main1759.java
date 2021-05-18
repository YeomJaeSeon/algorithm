package baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 서로다른 알파벳소문자
// 최소한개의 모음
// 최소 두개의 자음
public class Main1759 {
    static int L;
    static int C;
    static char[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        visited = new boolean[C];

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < C; i++){
            arr[i] = st2.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        combination(0, 0);


    }
    static void combination(int startIdx, int M){
        if(M == L){
            for(int i = 0; i < C; i++) {
                if (visited[i]) System.out.print(arr[i]);
            }
            System.out.println();
            return;
        }

        for(int i = startIdx; i < C; i++){
            visited[i] = true;
            if(M != L - 1 || isValid()) {
                combination(i + 1, M + 1);
            }
            visited[i] = false;
        }
    }
    static boolean isValid(){
        int cnt1 = 0; //모음
        int cnt2 = 0; // 자음
        for(int i = 0; i < C; i++) {
            if (visited[i]) {
                if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') ++cnt1;
                else ++cnt2;
            }
        }
        if(cnt1 >= 1 && cnt2 >= 2)
            return true;
        return false;
    }
}

/**
 * 틀렸습니다.
 * 크기가 L이고 isValid하지않으면 재귀함수만 호출되지않도록해야하는데 continue를해서 false로 visited를 초기화하지않아서
 * 많이 틀렸따.
 */
