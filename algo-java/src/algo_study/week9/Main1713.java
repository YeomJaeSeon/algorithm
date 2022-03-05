package algo_study.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1713 {
    static int N, M; // N: 사진틀의 개수
    //M: 총 추천의 개수
    static int[] students = new int[101];
    static Queue<Integer> times = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < M; i++){
            int vote = Integer.parseInt(st.nextToken());
            if(times.size() == N){
                //남는 사진틀 X
                boolean isAlreadyContains = false;
                for(int j = 1; j < 101; j++){
                    if(students[j] == 0) continue;
                    if(vote == j) isAlreadyContains = true;
                }
                if (!isAlreadyContains) {
                    int deletedIdx = findDeletedIdx(); //가장 작고 가장 오래된 후보
                    students[deletedIdx] = 0;
                    times.remove(deletedIdx);
                }
            }

            students[vote]++;
            if (!times.contains(vote)) {
                times.offer(vote);
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 1; i < 101; i++){
            if(students[i] > 0) result.add(i);
        }

        Collections.sort(result);

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }



    }
    static int findDeletedIdx(){
        int min = 1001;

        //find 최소 추천수
        for(int i = 1; i < 101; i++){
            if(students[i] == 0) continue;
            min = Math.min(min, students[i]);
        }

        //최소 추천수 인 학생이 여러명인지 알기위한 리스트
        List<Integer> minList = new ArrayList<>();
        for(int i = 1; i < 101; i++){
            if(students[i] == min) {
                minList.add(i);
            }
        }

        if(minList.size() == 1){
            // 최소가 한명이면 해당학생을 삭제해야함
            return minList.get(0);
        }else if(minList.size() > 1){
            // 최소가 여러명이면 가장오래된 학생을 삭제해야함
            Iterator<Integer> iterator = times.iterator();
            while(iterator.hasNext()){
                Integer next = iterator.next();
                if(minList.contains(next))
                    return next;
            }
        }

        return -1; //error
    }
}

/**
 * 최소 추천수인 후보가 여러명일때 오래된 후보를 삭제해야하는데, 오래된 후보가 누군지뽑는과정이 생각보다 어려웠음
 */