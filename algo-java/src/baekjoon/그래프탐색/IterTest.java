package baekjoon.그래프탐색;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class IterTest {
    static List<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        for(int i = 1; i <= 10; i++){
            list.add(i);
        }
        ListIterator<Integer> listIterator = list.listIterator();

        while(listIterator.hasNext()){
            listIterator.next();
        }
        System.out.println(list);
        System.out.println("next : " + listIterator.nextIndex());
        System.out.println("previous : " + listIterator.previousIndex());

        listIterator.add(100);
        System.out.println(list);
        System.out.println("next : " + listIterator.nextIndex());
        System.out.println("previous : " + listIterator.previousIndex());

        listIterator.add(100);
        System.out.println(list);
        System.out.println("next : " + listIterator.nextIndex());
        System.out.println("previous : " + listIterator.previousIndex());

        listIterator.add(100);
        System.out.println(list);
        System.out.println("next : " + listIterator.nextIndex());
        System.out.println("previous : " + listIterator.previousIndex());
    }
}
