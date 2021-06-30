package programmers;

import java.util.HashSet;
import java.util.Set;

public class 포켓몬 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 2, 4, 5}));
    }
    public static int solution(int[] nums) {
        int answer = 0;
        int initLength = nums.length;

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        if(initLength / 2 > set.size()){
            answer = set.size();
        }else{
            answer = initLength / 2;
        }

        return answer;
    }
}

/**
 입력된 배열의 크기중
 절반으로 나눈것을 고를수잇음
 고를때, 종류가 가장많게 고르는것이문제

 풀이
 Set을 이용해서 중복X, 순서X의 특징을 이용해서
 nums배열의 값을 모두 set에 넣어 중복을 없앤다
 그리고 nums.length / 2보다 작으면 해당 set.size()를 반환하고
 그렇지않으면 nums.length / 2 를 반환하면
 가장많은 종류의 포켓못은 반환할수있따.

 **/