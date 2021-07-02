package programmers;

import java.util.Arrays;

public class 로또의_최고_순위와_최저_순위 {
    public static void main(String[] args) {
        Arrays.sort(solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19}));
    }
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int ZeroCount = 0;
        int correctCount = 0;
        Arrays.sort(win_nums); //bs위해

        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0) {
                ZeroCount++;
                continue;
            }
            if(binarySearch(0, lottos.length - 1, lottos[i], win_nums) != -1){
                correctCount++;
            }
        }

        answer = changeScoreToRanking(correctCount, ZeroCount);


        System.out.println(Arrays.toString(answer));

        return answer;
    }
    public static int binarySearch(int start, int end, int target, int[] win_nums){
        while(start <= end){
            int mid = (start + end) / 2;
            if(win_nums[mid] == target){
                return mid;
            }else if(win_nums[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
    public static int[] changeScoreToRanking(int correctCount, int ZeroCount){
        int grade = 0;
        int grade2 = 0;
        switch(correctCount){
            case 6:
                grade = 1;
                break;
            case 5:
                grade = 2;
                break;
            case 4:
                grade = 3;
                break;
            case 3:
                grade = 4;
                break;
            case 2:
                grade = 5;
                break;
            default:
                grade = 6;
                break;
        }
        switch(correctCount + ZeroCount){
            case 6:
                grade2 = 1;
                break;
            case 5:
                grade2 = 2;
                break;
            case 4:
                grade2 = 3;
                break;
            case 3:
                grade2 = 4;
                break;
            case 2:
                grade2 = 5;
                break;
            default:
                grade2 = 6;
                break;
        }

        return new int[]{grade2, grade};
    }
}

/**
 탐색문제임
 최고순위는 0인게 모두 당첨번호이고
 최저순위는 0인게 모두 당첨번호가 아닌것..

 완전탐색해도됨, 그러나 BS로함

 **/