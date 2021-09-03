package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main16236 {
    static int N;
    static int[][] board;
    static int startX, startY;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static List<BabyShark> feedList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                int value = Integer.parseInt(st.nextToken());
                if(value == 9){
                    startX = i;
                    startY = j;
                }else{
                    board[i][j] = value;
                }
            }
        }


        System.out.println(bfs(startX, startY));
    }
    static int bfs(int x, int y){
        int babySharkSize = 2;
        int eatCount = 0;
        Queue<BabyShark> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new BabyShark(x, y, 0));
        int totalTimes = 0;

        while(true){
            while(!q.isEmpty()){
                BabyShark current = q.poll();
                for(int i = 0; i < 4; i++){
                    int nextX = current.x + dx[i];
                    int nextY = current.y + dy[i];

                    if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                    if(!visited[nextX][nextY] && (board[nextX][nextY] == 0 || board[nextX][nextY] == babySharkSize)){
                        q.offer(new BabyShark(nextX, nextY, current.times + 1));
                        visited[nextX][nextY] = true;
                        continue;
                    }
                    if(!visited[nextX][nextY] && board[nextX][nextY] != 0 && board[nextX][nextY] < babySharkSize){
                        //can eat
                        feedList.add(new BabyShark(nextX, nextY, current.times + 1));
                        q.offer(new BabyShark(nextX, nextY, current.times + 1));
                        visited[nextX][nextY] = true;
                        continue;
                    }
                }
            }
            if(!feedList.isEmpty()){
                Collections.sort(feedList, (o1, o2) -> {
                    if(o1.times == o2.times){
                        if(o1.x == o2.x){
                            return o1.y - o2.y;
                        }else{
                            return o1.x - o2.x;
                        }
                    }else{
                        return o1.times - o2.times;
                    }
                });
                //먹을수있는 먹이중 가장 가까우면서 위쪽 그리고 왼쪽에있는 먹이 찾기
                BabyShark feed = feedList.get(0); //먹을 먹이

                eatCount++;
                if(eatCount == babySharkSize){
                    babySharkSize++;
                    eatCount = 0;
                }
                totalTimes += feed.times;

                feedList.clear(); //먹이 리스트 비워주기
                visited = new boolean[N][N]; // 방문 처리 초기화
                visited[feed.x][feed.y] = true; //(처음 탐색 시작지점)
                board[feed.x][feed.y] = 0; // 먹었으니 0으로 바꾸어줌
                q.offer(new BabyShark(feed.x, feed.y, 0));
            }else{
                break;
            }
        }
        return totalTimes;
    }
}

class BabyShark{
    int x;
    int y;
    int times;

    public BabyShark(int x, int y, int times) {
        this.x = x;
        this.y = y;
        this.times = times;
    }

    @Override
    public String toString() {
        return "BabyShark{" +
                "x=" + x +
                ", y=" + y +
                ", times=" + times +
                '}';
    }
}
