package training.sort_algorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//퀵정렬 피벗 : 맨 왼쪽 원소
public class QuickSort {
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

        sort_quickSort(arr, 0, arr.length - 1);

        System.out.println("after sorting");
        System.out.println(Arrays.toString(arr));
    }
    static void sort_quickSort(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int pivot = start;
        int i = start + 1;
        int j = end;

        while(i <= j){
            while(i <= end && arr[i] <= arr[pivot]){
                i++;
            }
            while(j > start && arr[j] >= arr[pivot]){
                j--;
            }
            if(i > j){
                int tmp = arr[j];
                arr[j] = arr[pivot];
                arr[pivot] = tmp;
            }else{
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }

        sort_quickSort(arr, start, j - 1);
        sort_quickSort(arr, j + 1, end);
    }
}
