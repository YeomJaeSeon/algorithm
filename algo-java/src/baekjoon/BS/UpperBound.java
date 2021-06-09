package baekjoon.BS;

import java.util.Scanner;

public class UpperBound {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();

        arr = new int[]{1, 1, 2, 2, 2, 3, 4, 4, 5, 7, 7, 9};

        System.out.println(upperBs(0, arr.length - 1, target));

    }
    static int upperBs(int start, int end, int target){

        while(start < end){
            int mid = (start + end) / 2;
            if(arr[mid] <= target){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }
}
