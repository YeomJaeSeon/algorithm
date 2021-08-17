package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main11656 {
    static String word;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        for(int i = 0; i < word.length(); i++){
            list.add(word.substring(i));
        }
        Collections.sort(list);
        list.stream().forEach(System.out::println);
    }
}
