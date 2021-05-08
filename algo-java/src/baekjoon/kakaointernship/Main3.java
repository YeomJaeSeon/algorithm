package baekjoon.kakaointernship;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {

        Solution2 solution = new Solution2();
        String result = solution.solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"});
        System.out.println(result);
    }
}

class Solution2 {
    public String solution(int n, int k, String[] cmd) {
        int[] list = new int[n];
        for(int i = 0; i < n; i++){
            list[i] = i;
        }
        // 초기상태
        Stack<Integer> beforeWorking = new Stack<>();

        //현재는 k가르키고잇음

        for (String s : cmd) {
            // 이동
            if(s.length() == 3){
                StringTokenizer st = new StringTokenizer(s, " ");
                String direction = st.nextToken();
                int count = Integer.parseInt(st.nextToken());
                if(direction.equals("D")){
                    //down
                    int curr = 0;
                    for(int i = 0; i < n; i++){
                        if(list[i] == k) curr = i;
                    }

                    while(count > 0){
                        if(list[curr++] == -1)
                            continue;
                        count--;
                    }
                    k = curr;
                }else{
                    //up
                    int curr = 0;
                    for(int i = 0; i < n; i++){
                        if(list[i] == k) curr = i;
                    }

                    while(count > 0){
                        if(list[curr--] == -1)
                            continue;
                        count--;
                    }
                    k = curr;
                }
            }else{
                // 삭제나 되돌리기
                if(s.equals("C")){
                    // 삭제
                    int max = 0;
                    for(int i = 0; i < n; i++){
                        max = Math.max(list[i], max);
                    }
                    if(k == max){
                        for(int i = 0; i < n; i++){
                            if(list[i] == k){
                                list[i] = -1;
                                break;
                            }
                        }
                        beforeWorking.push(k);
                        k -= 1;
                    }else{
                        for(int i = 0; i < n; i++){
                            if(list[i] == k){
                                list[i] = -1;
                                break;
                            }
                        }
                        beforeWorking.push(k);
                        int increase = k;
                        for(int i = k + 1; i < n; i++){
                            list[i] = increase++;
                        }
                    }

                }else{
                    // 되돌리기
                    Integer poll = beforeWorking.pop();
                    int value = 0;
                    for(int i = 0; i < n; i++){
                        if(list[i] != -1) value++;
                        if(i == poll){
                            for(int j = poll; j < n; j++){
                                list[j] = ++value;
                            }
                        }
                    }
                }
            }
        }


        String answer = "";
        for(int i = 0; i < list.length; i++){
            if(list[i] != -1){
                answer += "0";
            }else{
                answer += "X";
            }
        }
        return answer;
    }
}