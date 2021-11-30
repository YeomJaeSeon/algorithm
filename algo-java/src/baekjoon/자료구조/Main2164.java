package baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main2164 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = N; i >= 1; i--){
            deque.add(i);
        }

        while(deque.size() > 1){
            deque.pollLast();
            Integer pollValue = deque.pollLast();
            deque.addFirst(pollValue);
        }

        System.out.println(deque.getFirst());

    }
}
