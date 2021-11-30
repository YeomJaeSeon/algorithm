package contest.nhn_practice;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class PqTest {
    static List<Integer> list;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        pq.offer(10);
        pq.offer(3);
        pq.offer(1200);

        System.out.println(pq);

        System.out.println(pq.poll());

        list = Arrays.asList(10, 2, 3);

        Collections.sort(list, Comparator.reverseOrder());
        System.out.println(list);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write("hi");

    }
}
