package training.sort_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MergeSort3 {
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

        sort_mergeSort();

        System.out.println("after sorting");
        System.out.println(Arrays.toString(arr));
    }
    static void sort_mergeSort(){
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
    }
    static void mergeSort(int[] arr, int[] tmp, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;
            mergeSort(arr, tmp, start, mid);
            mergeSort(arr, tmp,mid + 1, end);
            merge(arr, tmp, start, mid, end);
        }
    }
    static void merge(int[] arr, int[] tmp, int start, int mid, int end){
        for(int i = start; i <= end; i++){
            tmp[i] = arr[i];
        }

        int part1 = start;
        int part2 = mid + 1;
        int idx = start;

        while(part1 <= mid && part2 <= end){
            if(tmp[part1] <= tmp[part2]){
                arr[idx] = tmp[part1];
                part1++;
            }else{
                arr[idx] = tmp[part2];
                part2++;
            }
            idx++;
        }

        if(part1 <= mid){
            for(int i = 0; i <= mid - part1; i++){
                arr[idx + i] = tmp[part1 + i];
            }
        }
        if(part2 <= end){
            for(int i = 0; i <= end - part2; i++){
                arr[idx + i] = tmp[part2 + i];
            }

        }
    }
}
