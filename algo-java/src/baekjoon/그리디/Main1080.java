package baekjoon.그리디;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1080 {
    static int N, M;
    static int[][] inputMatrix;
    static int[][] resultMatrix;
    static int flipCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inputMatrix = new int[N][M];
        resultMatrix = new int[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j= 0; j < M; j++){
                inputMatrix[i][j] = str.charAt(j) == '0' ? 0 : 1;
            }
        }

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j= 0; j < M; j++){
                resultMatrix[i][j] = str.charAt(j) == '0' ? 0 : 1;
            }
        }

        // 예외처리
        if(N < 3 || M < 3){
            if(Arrays.deepEquals(inputMatrix, resultMatrix)) System.out.println(0);
            else System.out.println(-1);
            return;
        }

        //main
        for(int i = 0; i <= N - 3; i++){
            for(int j = 0; j <= M - 3; j++){
                if(inputMatrix[i][j] != resultMatrix[i][j]) {
                    flip(i, j);
                    flipCount++;
                }
            }
        }

        if(Arrays.deepEquals(inputMatrix, resultMatrix)){
            System.out.println(flipCount);
        }else{
            System.out.println(-1);
        }

    }
    static void flip(int x, int y){
        for(int i = x; i < x + 3; i++){
            for(int j = y; j < y + 3; j++){
                inputMatrix[i][j] = inputMatrix[i][j] == 1 ? 0 : 1;
            }
        }
    }
}


/**
 이 문제는 3 * 3의 부분행렬을 하나의 통으로 보는것이 중요하다생각한다..
 연산이란 3*3 부분행렬의 내부 값들을 모두 reverse하는 것인데
 그러기 때문에 하나의 통으로 봐야한다.

 그래서 어떠한 값에 대한 비교도 0 ~ N - 3까지만 해야한다.
 (0, 0) ~ (N - 3, N - 3)값에대한 비교만해야한다.
 왜냐면 해당 경우의 개수가 3*3 통이 존재하는 개수이기 때문이다.

 그리고 reverse하는 것이라서 두번 reverse되면 reverse 안한것과 같다.
 이걸 유념하면 flip하거나 안하거나
 둘중하나의 선택만해야하기에 최소 연산의 수를 구할수있는것이다.

 위 두가지 생각으로 풀면
 뒤집거나 뒤집지않으면 최소연산수 얻게되고

 3*3 통을 비교해야하므로 (0, 0) ~ (N - 3, M - 3)의 경우의 수의 값만 비교해야한다.


 틀린이유
 - 3*3통으로 생각하지않아서 3*3 내부 모든 원소를 비교함..
 **/