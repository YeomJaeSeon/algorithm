package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2012 {
    static int N;
    static List<Integer> list = new ArrayList<>();
    static long sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        //오름차순정렬
        for(int i = 0; i < N; i++){
            sum += calculateDissatisfaction(i + 1, list.get(i));
        }
        System.out.println(sum);
    }
    static int calculateDissatisfaction(int realGrade, int aspectGrade){
        return Math.abs(realGrade - aspectGrade);
    }
}

/**
 너무쉽다
 일단 등수는 1부터 N까지로 할당되야함
 예상등수를 오름차순한다음 각 수에 매핑되는 실제수를 뺴는것이 불만도를 최소로 하는것임
 1 3 5 7 9
 1 2 3 4 5
 각수에 매핑되는걸 빼는 합이 최소인게

 불만도최소로하는 방버임

 **/