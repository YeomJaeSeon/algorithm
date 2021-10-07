package training.backtracking;

import java.io.*;
import java.util.*;

//1 7 9 9
//1 7 9 9
public class Main15663 {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static int[] result;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        recursive(0);

        for (int[] ints : list) {
            for(int i = 0; i < M; i++){
                bw.write(ints[i] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    static void recursive(int m) throws IOException{
        if(m == M){
            int[] inputArr = new int[M];
            for(int i = 0; i < M; i++){
                inputArr[i] = arr[result[i]];
            }

            for (int[] ints : list) {
                if(Arrays.equals(ints, inputArr))
                    return;
            }

            list.add(inputArr);
            return;
        }
        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                result[m] = i;
                recursive(m + 1);
                visited[i] = false;
            }
        }
    }

}

//1 7 9 9
//네개중 2개를 뽑는데
/**
 * 1 7
 * 1 9
 * 7 1
 * 7 9
 * 9 1
 * 9 7
 * 9 9
 * 9 1
 * 9 7
 * 9 9
 */