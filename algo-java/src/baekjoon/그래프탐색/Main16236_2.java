package baekjoon.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main16236_2 {
    static int N;
    static int[][] board;
    static int startX, startY;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static List<Shark> feedList = new ArrayList<>();

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
    static int bfs(int startX, int startY){
        int sharkSize = 2;
        int eatCount = 0;
        Queue<Shark> q = new LinkedList<>();
        q.offer(new Shark(startX, startY, 0));
        visited[startX][startY] = true;
        int totalCount = 0;

        while(true){
            while(!q.isEmpty()){
                Shark current = q.poll();
                for(int i = 0; i < 4; i++){
                    int nextX = current.x + dx[i];
                    int nextY = current.y + dy[i];

                    if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                    if(!visited[nextX][nextY] && board[nextX][nextY] != 0 && sharkSize > board[nextX][nextY]){
                        visited[nextX][nextY] = true;
                        q.offer(new Shark(nextX, nextY, current.moveCount + 1));
                        feedList.add(new Shark(nextX, nextY, current.moveCount + 1));
                        continue;
                    }
                    if(!visited[nextX][nextY] && (board[nextX][nextY] == 0 || board[nextX][nextY] == sharkSize)){
                        visited[nextX][nextY] = true;
                        q.offer(new Shark(nextX, nextY, current.moveCount + 1));
                        continue;
                    }
                }
            }

            if(!feedList.isEmpty()){
                Collections.sort(feedList, (o1, o2) -> {
                    if(o1.moveCount == o2.moveCount){
                        if(o1.x == o2.x){
                            return o1.y - o2.y;
                        }else{
                            return o1.x - o2.x;
                        }
                    }else{
                        return o1.moveCount - o2.moveCount;
                    }
                });

                Shark feed = feedList.get(0);
                totalCount += feed.moveCount;
                eatCount++;
                if(eatCount == sharkSize){
                    sharkSize++;
                    eatCount = 0;
                }
                feedList = new ArrayList<>();
                visited = new boolean[N][N];
                q.offer(new Shark(feed.x, feed.y, 0));
                visited[feed.x][feed.y] = true;
                board[feed.x][feed.y] = 0;
            }else{
                break;
            }
        }
        return totalCount;
    }
}

class Shark{
    int x;
    int y;
    int moveCount;

    public Shark(int x, int y, int moveCount) {
        this.x = x;
        this.y = y;
        this.moveCount = moveCount;
    }

    @Override
    public String toString() {
        return "Shark{" +
                "x=" + x +
                ", y=" + y +
                ", moveCount=" + moveCount +
                '}';
    }
}
