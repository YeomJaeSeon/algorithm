package programmers;

import java.util.Arrays;

public class 타겟넘버 {
    static boolean[] visited;
    static int M;
    static int totalCount;
    static int globalTarget;
    static int[] globalNumbers;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
    }
    public static int solution(int[] numbers, int target) {
        // numbers 길이 : 2 ~ 20
        //각 원소값  : 1 ~ 50
        // target : 1 ~ 1000
        globalNumbers = numbers;
        globalTarget = target;

        visited = new boolean[numbers.length + 1];

        int sum = 0;
        for(int i = 0; i < numbers.length; i++){
            sum += numbers[i];
        }
        if(sum == target){
            totalCount++;
        }

        for(int i = 1; i <= numbers.length; i++){
            M = i;
            //음수의 개수
            dfs(1, 0, numbers.length);
            Arrays.fill(visited, false);
        }


        return totalCount;
    }
    public static void dfs(int start, int m, int length){
        if(m == M){
            int sum = 0;

            for(int i = 1; i < visited.length; i++){
                if(visited[i]){
                    sum -= globalNumbers[i - 1];
                }else{
                    sum += globalNumbers[i - 1];
                }
            }

            if(sum == globalTarget){
                totalCount++;
            }

            return;
        }
        for(int i = start; i < length + 1; i++){
            visited[i] = true;
            dfs(i + 1, m + 1, length);
            visited[i] = false;
        }
    }
}

/**
 붹트래킹으로 풀면됨
 dfs로...

 조합을 이용하면된다!

 **/