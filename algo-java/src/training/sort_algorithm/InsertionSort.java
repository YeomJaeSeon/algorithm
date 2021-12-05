package training.sort_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//삽입 정렬
public class InsertionSort {
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

        sort_insertion();

        System.out.println("after sorting");
        System.out.println(Arrays.toString(arr));
    }
    static void sort_insertion(){
        for(int i = 1; i < N; i++){
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && key < arr[j]){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}

/**
 * 삽입 정렬
 * 시간복잡도 : O(n^2)
 * 공간복잡도 : O(n)
 */