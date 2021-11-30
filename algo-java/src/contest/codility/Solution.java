package contest.codility;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) {
        solution("011101");
    }
    public static int solution(String S){
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '1'){
                deque.offer(1);
            }else{
                deque.offer(0);
            }
        }

        while(!isValid(deque)){
            if(deque.peekLast() == 1){
                //홀수
                deque.pollLast();
                deque.offer(0);
            }else{
                //짝수
                deque.pollLast();
                deque.addFirst(0);
            }
        }



        return 0;
    }
    public static boolean isValid(Deque<Integer> deque){
        int sum = 0;
        for (Integer integer : deque) {
            sum += integer;
        }


        if(sum == 0) return true; // 끝조건
        return false;
    }
}
