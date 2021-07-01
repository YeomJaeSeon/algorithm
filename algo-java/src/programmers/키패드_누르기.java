package programmers;

public class 키패드_누르기 {
    static int leftPosX, leftPosY; // 현재위치
    static int rightPosX, rightPosY;
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }
    public static String solution(int[] numbers, String hand) {
        String answer = "";
        leftPosX = 3;
        leftPosY = 0;
        rightPosX = 3;
        rightPosY = 2;

        for(int i = 0; i < numbers.length; i++){
            int target = numbers[i];
            if(target == 1 || target == 4 || target == 7){
                if(target == 1){
                    leftPosX = 0;
                    leftPosY = 0;
                }else if(target == 4){
                    leftPosX = 1;
                    leftPosY = 0;
                }else{
                    leftPosX = 2;
                    leftPosY = 0;
                }

                answer += "L";
            }else if(target == 3 || target == 6 || target == 9){
                if(target == 3){
                    rightPosX = 0;
                    rightPosY = 2;
                }else if(target == 6){
                    rightPosX = 1;
                    rightPosY = 2;
                }else{
                    rightPosX = 2;
                    rightPosY = 2;
                }

                answer += "R";
            }else{
                // 2 5 8 0
                int targetX = 0;
                int targetY = 0;
                if(target == 2){
                    targetX = 0;
                    targetY = 1;
                }else if(target == 5){
                    targetX = 1;
                    targetY = 1;
                }else if(target == 8){
                    targetX = 2;
                    targetY = 1;
                }else if(target == 0){
                    targetX = 3;
                    targetY = 1;
                }
                int leftDiff = Math.abs(leftPosX - targetX) + Math.abs(leftPosY - targetY);
                //왼손과의 거리
                int rightDiff = Math.abs(rightPosX - targetX) + Math.abs(rightPosY - targetY);
                //오른손과의 거리

                if(leftDiff > rightDiff){
                    answer += "R";
                    rightPosX = targetX;
                    rightPosY = targetY;
                }else if(leftDiff < rightDiff){
                    answer += "L";
                    leftPosX = targetX;
                    leftPosY = targetY;
                }else{
                    if(hand.equals("right")){
                        answer += "R";
                        rightPosX = targetX;
                        rightPosY = targetY;
                    }else{
                        answer += "L";
                        leftPosX = targetX;
                        leftPosY = targetY;
                    }
                }

            }
        }

        return answer;
    }
}

/**
 구현으로 품

 **/