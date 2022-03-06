package algo_study.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 다른 극이 맞닿아있을때만 회전(서로 다른극은 반대 방향으로 회전
// 0 : N, 1 : S
// 1: 시계, -1: 반시계
public class Main14891 {
    static List<int[]> list = new ArrayList<>(); //톱니바퀴 정보담김
    static int K; // 1 <= K <= 100

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 4; i++){
            list.add(new int[8]);
        }

        for(int i = 0; i < 4; i++){
            String state = br.readLine();
            int[] obj = list.get(i);
            for(int j = 0; j < 8; j++){
                obj[j] = Integer.parseInt(state.charAt(j) + "");
            }
        }
        K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int idx = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            //1: 시계, -1: 반시계
            findRotateObjsAndRotate(idx - 1, direction);
        }

        // 게임 다 끝나면점수 합 구해야함
        System.out.println(calculateScore());
    }
    static void findRotateObjsAndRotate(int standardObjIdx, int direction){
        int[] standardObj = list.get(standardObjIdx);

        List<Integer> mustRotate = new ArrayList<>();
        List<Integer> mustReverseRotate = new ArrayList<>();
        //시계 반시계 돌아야할 녀석들 저장하는 자료구조

        if(direction == 1) mustRotate.add(standardObjIdx);
        else mustReverseRotate.add(standardObjIdx);


        //왼쪽
        boolean isLeftRotate = true;
        int leftRotateDir = direction == 1 ? -1 : 1;
        for(int i = standardObjIdx - 1; i >= 0; i--){
            int[] anotherObj = list.get(i);
            if(isLeftRotate && standardObj[6] != anotherObj[2]){
                if(leftRotateDir == 1){
                    mustRotate.add(i);
                    leftRotateDir = -1; //방향도 바꿔줘야함
                }else{
                    mustReverseRotate.add(i);
                    leftRotateDir = 1;
                }
                standardObj = anotherObj;
            }else{
                //그 다음애들은 그만돌아야함
                isLeftRotate = false;
            }
        }
        //오른쪽
        standardObj = list.get(standardObjIdx);
        boolean isRightRotate = true;
        int rightRotateDir = direction == 1 ? -1 : 1;;
        for(int i = standardObjIdx + 1; i < 4; i++){
            int[] anotherObj = list.get(i);
            if(isRightRotate && standardObj[2] != anotherObj[6]){
                if(rightRotateDir == 1){
                    mustRotate.add(i);
                    rightRotateDir = -1;
                }else{
                    mustReverseRotate.add(i);
                    rightRotateDir = 1;
                }
                standardObj = anotherObj;
            }else{
                //그 다음애들은 그만돌아야함
                isRightRotate = false;
            }
        }

        for (Integer idx : mustRotate) {
            rotate(list.get(idx));
        }

        for (Integer idx : mustReverseRotate) {
            rotateReverse(list.get(idx));
        }
    }
    static void rotate(int[] obj){
        int tmp = obj[7];

        for(int i = 6; i >= 0; i--){
            obj[i + 1] = obj[i];
        }
        obj[0] = tmp;
    }
    static void rotateReverse(int[] obj){
        int tmp = obj[0];

        for(int i = 1; i < 8; i++){
            obj[i - 1] = obj[i];
        }

        obj[7] = tmp;
    }
    static int calculateScore(){
        int sum = 0;
        for(int i = 0; i < 4; i++){
            int[] obj = list.get(i);
            switch (i){
                case 0:
                    if(obj[0] == 1){
                        sum += 1;
                    }
                    break;
                case 1:
                    if(obj[0] == 1){
                        sum += 2;
                    }
                    break;
                case 2:
                    if(obj[0] == 1){
                        sum += 4;
                    }
                    break;
                case 3:
                    if(obj[0] == 1){
                        sum += 8;
                    }
                    break;
            }
        }
        return sum;
    }

}

/**
 * 하나씩 구현하면서 풀면됨
 *
 * 두번 틀린이유
 * - 다음 톱니바퀴를 돌려야하는지 검사할때, 이전 톱니바퀴를 갱신하지않아줌
 * 즉, 처음에 돌기 시작한 톱니바퀴를 갱신하지않으며 해당 톱니바퀴만으로 다음톱니바퀴가 돌지 안돌지를 정하고 있엇음
 *
 */