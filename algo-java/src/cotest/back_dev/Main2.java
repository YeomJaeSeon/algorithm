package cotest.back_dev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2 {
    static final String[] WEEK = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
    static List<Integer> holidayList = new ArrayList<>();
    static boolean[] visited = new boolean[31]; //true : 쉬는날
    static int max = -1;
    public static void main(String[] args) {
        System.out.println(solution(29, "FRI", new int[]{6, 21, 23, 27, 28}));
        // 연차쓸수있는 일수 , 달의 첫날이 시작하는 요일, 공휴일이 담겨있는 배열
        //가장 길게 휴가를 떠나기  위해 연차를 잘써봐라
    }
    static int solution(int leave, String day, int[] holidays){
        for (int holiday : holidays) {
            holidayList.add(holiday);
        }
        addWeekendsInHolidays(day);

        Collections.sort(holidayList);

        for (Integer integer : holidayList) {
            System.out.println(integer);
        }

        for (Integer v : holidayList) {
            visited[v] = true; //쉬는날 설정
        }

        recursive(leave, 0);

        int answer = max;
        return answer;
    }
    static void addWeekendsInHolidays(String day){
        int startDate = -1;
        for(int i = 0; i < 7; i++){
            if(WEEK[i].equals(day)) startDate = i;
        }

        for(int i = 1; i <= 30; i++){
            if(startDate == 5){
                if(!holidayList.contains(i)) holidayList.add(i);
                startDate++;
            }else if(startDate == 6){
                if(!holidayList.contains(i)) holidayList.add(i);
                startDate = 0;
            }else{
                startDate++;
            }
        }
    }
    static void recursive(int leave, int m){
        if(leave == m){
            int count = 0;
            for(int i = 1; i <= 30; i++){
                if(visited[i]) count++;
                else count = 0;
                max = Math.max(max, count);
            }

            return;
        }
        for(int i = 1; i <= 30; i++){
            if(!visited[i]){
                //쉬는날 아니면
                visited[i] = true;
                recursive(leave, m + 1);
                visited[i] = false;
            }
        }
    }
}
