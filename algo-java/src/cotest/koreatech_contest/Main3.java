package cotest.koreatech_contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main3 {
    static int T;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int w, h;
    static char[][] board;
    static boolean[][] visited;
    static int keyCount;
    static final int ASCII = 32;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            board = new char[h][w];
            visited = new boolean[h][w];

            keyCount = 0;

            boolean isExistStart = false;

            int startX = 0;
            int startY = 0;

            for(int j = 0; j < h; j++){
                String str = br.readLine();
                for(int k = 0; k < w; k++){
                    board[j][k] = str.charAt(k);
                    if(str.charAt(k) == '?'){
                        startX = j;
                        startY = k;
                        isExistStart = true;
                    }
                    if(str.charAt(k) >= 'a' && str.charAt(k) <= 'z')
                        keyCount++;
                }
            }

            if(!isExistStart){
                System.out.println(-1);
            }else{
                if(keyCount == 0){
                    System.out.println(-1);
                }else{
                    System.out.println(bfs(startX, startY));
                }
            }
        }
    }
    static int bfs(int startX, int startY){
        Queue<JongWook> q = new LinkedList<>();
        q.offer(new JongWook(startX, startY, 0));
        visited[startX][startY] = true;

        List<Character> myKeys = new ArrayList<>(); //키를 담을 주머니

        while(!q.isEmpty()){
            JongWook poll = q.poll();
            int currentX = poll.x;
            int currentY = poll.y;
            int currentCount = poll.count;

            for(int i = 0; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX < 0 || nextX >= h || nextY < 0 || nextY >= w) continue;
                if(board[nextX][nextY] == '$') continue; //벽

                if(!visited[nextX][nextY]){
                    if(isKey(nextX, nextY)){
                        if(myKeys.contains(board[nextX][nextY])){
                            //이미 주머니에 키가 있는 상태라면
                            visited[nextX][nextY] = true;
                            q.offer(new JongWook(nextX, nextY, currentCount + 1));
                            continue;
                        }

                        //내 주머니에 키가 없다면.
                        myKeys.add(board[nextX][nextY]); // 키를 내 주머니에담는다.
                        visited = new boolean[h][w]; //방문처리 초기화
                        visited[nextX][nextY] = true;
                        q.clear(); //큐비우기
                        q.offer(new JongWook(nextX, nextY, currentCount + 1));

                        if(--keyCount == 0){
                            //키 다찾으면
                            return currentCount + 1;
                        }
                        break;
                    }

                    if(isDoor(nextX, nextY)){
                        if(myKeys.contains((char)(board[nextX][nextY] + ASCII))){
                            visited[nextX][nextY] = true;
                            q.offer(new JongWook(nextX, nextY, currentCount + 1));
                            continue;
                        }else{
                            continue;
                        }
                    }

                    visited[nextX][nextY] = true;
                    q.offer(new JongWook(nextX, nextY, currentCount + 1));
                }
            }
        }
        return -1;
    }
    static boolean isKey(int x, int y){
        if(board[x][y] >= 'a' && board[x][y] <= 'z')
            return true;
        return false;
    }
    static boolean isDoor(int x, int y){
        if(board[x][y] >= 'A' && board[x][y] <= 'Z')
            return true;
        return false;
    }
}

class JongWook{
    int x;
    int y;
    int count;

    public JongWook(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }

    @Override
    public String toString() {
        return "JongWook{" +
                "x=" + x +
                ", y=" + y +
                ", count=" + count +
                '}';
    }
}
