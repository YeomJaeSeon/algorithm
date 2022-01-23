package baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main10817 {
    static int a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(a, b, c));
        Collections.sort(list);

        System.out.println(list.get(1));

    }
}

/**
 * 정렬해서 두번째 수 - 끝
 */