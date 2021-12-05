package training.sort_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BubbleSort {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println("before sorting");
        System.out.println(Arrays.toString(arr));

        sort_bubble();

        System.out.println("after sorting");
        System.out.println(Arrays.toString(arr));
    }
    static void sort_bubble(){
        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < N - 1 - i; j++){
                if(arr[j + 1] < arr[j]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}

/**
 * 빅오 표기법 : 실제적인 런타임 시간을 측정하는게 목적이아닌, 데이터 증가율에 따른 시간이 얼마나 증가되는지를 알기 위한 지표
 * 공간 복잡도 : 메모리 공간 얼마나 사용하는지
 * 시간 복잡도 : 런타임 얼마나 사용되는지
 *
 * 버블정렬
 * O(n^2) 시간복잡도
 * O(n) 공간복잡도
 */
