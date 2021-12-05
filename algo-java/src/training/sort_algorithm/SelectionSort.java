package training.sort_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//정렬은 오름차순 기준입니다.

//선택 정렬
public class SelectionSort {
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

        sort_selection();

        System.out.println("after sorting");
        System.out.println(Arrays.toString(arr));
    }

    static void sort_selection(){
        for(int i = 0; i < N - 1; i++){
            int min = i;
            for(int j = i + 1; j < N; j++){
                if(arr[j] < arr[min])
                    min = j;
            }
            int tmp = arr[min];
            arr[min] = arr[i];
            arr[i] = tmp;
        }
    }
}
/**
 * 선택정렬
 * 시간복잡도 : O(n^2)
 * 공간복잡도 : O(n)
 */