package baekjoon.재귀;

import java.io.*;
import java.util.Arrays;

public class Main2447 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][] board;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (char[] chars : board) {
            Arrays.fill(chars, '*');
        }

        play(N, 0, 0, N, N);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                bw.write(board[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
    // 왼쪽 위 좌표 : (x1, y1), 오른쪽 아래 : x2, y2
    static void play(int N, int x1, int y1, int x2, int y2){
        if(N == 1) return;

        for(int i = x1 + N / 3; i < x2 - N / 3; i++)
            for(int j = y1 + N / 3; j < y2 - N / 3; j++) {
                board[i][j] = ' ';
            }

        int a = 0;
        int b = N / 3;
        int c = 2 * (N / 3);
        int d = N;

        play(N / 3, x1 + a, y1 + a, x1 + b, y1 + b);
        play(N / 3, x1 + a, y1 + b, x1 + b, y1 + c);
        play(N / 3, x1 + a, y1 + c, x1 + b, y1 + d);
        play(N / 3, x1 + b, y1 + a, x1 + c, y1 + b);
        play(N / 3, x1 + b, y1 + c, x1 + c, y1 + d);
        play(N / 3, x1 + c, y1 + a, x1 + d, y1 + b);
        play(N / 3, x1 + c, y1 + b, x1 + d, y1 + c);
        play(N / 3, x1 + c, y1 + c, x1 + d, y1 + d);
    }
}

/**
 현재 N의 중앙 별을 지우는 형태로 재귀함수를돌림
 N을 3으로 나눠가면서 재귀함수를 호출
 그런데 자기를 둘러싼 8개의 영역에 대한 재귀함수를 호출해야하므로
 한번 함수호출시 8번의 재귀함수호출.
 8^7 의 시간복잡도를 갖는다. (최대)
 System.out.print() - 시간초과
 BufferedWrited - 해결

 헤맸던 부분은 재귀함수 호출할때 인자를 변경해주지않아서 많이 해멨다.
 **/