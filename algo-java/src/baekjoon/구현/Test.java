package baekjoon.구현;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 2, 0, 5};

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                if(i == arr.length - 1) break;
                int k = i + 1;
                while(arr[k] == 0){
                    k++;
                    if(k == arr.length) break;
                }
                if(k != arr.length){
                    arr[i] = arr[k];
                    arr[k] = 0;
                }

            }
        }
        System.out.println("arr = " + Arrays.toString(arr));
    }
}
