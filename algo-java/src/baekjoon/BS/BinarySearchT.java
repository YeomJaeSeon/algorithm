package baekjoon.BS;

import java.util.Scanner;

public class BinarySearchT {
    static int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    public static int binarySearch(int target, int start, int end){
        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] == target) return mid; // 찾으면 해당 인덱스 바환

            // 찾고자하는 값 이 중앙값(정렬이되어있음) 보다 작다면 end = mid - 1; 로바꿈
            else if(arr[mid] > target) end = mid - 1;

            // 찾고하자하는 값이 중앙값 보다 크다면 start = mid + 1로바꿈.
            else start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("target : ");
        int target = sc.nextInt();

        int result = binarySearch(target, 0, 9);
        if(result == -1){
            System.out.println("못찾았어요");
        }else{
            System.out.println(result + " index에 존재하네요");
        }
    }
}

