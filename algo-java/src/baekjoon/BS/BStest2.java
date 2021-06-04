package baekjoon.BS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BStest2 {
    static int[] intArr;
    static int target;
    static int resultIdx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        intArr = new int[count];

        for(int i = 0; i < count; i++){
            intArr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(Arrays.toString(intArr));

        System.out.printf("target : " );
        target = Integer.parseInt(br.readLine());

        Arrays.sort(intArr); //정렬

        binarySearch(0, count - 1);

        System.out.println("resultIdx = " + resultIdx);

    }
    static void binarySearch(int start, int end){
        while(start <= end){
            int mid = (start + end) / 2;
            if(target == intArr[mid]){
                resultIdx = mid;
                return;
            }else if(target > intArr[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        resultIdx = -1;
        return;
    }
}
