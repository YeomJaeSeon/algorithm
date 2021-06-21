package baekjoon.자료구조;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main1927 {
    static int N;
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println("max = " + max);

    }
}
