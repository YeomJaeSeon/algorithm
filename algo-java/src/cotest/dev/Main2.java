package cotest.dev;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.solution(new int[]{0,0,1,1,1,0,1,0,1,0,1,1},
                new int[][]{
                        {0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}
                });

    }
}

class Solution {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int sheepCount = 1;
    static int wolfCount = 0;
    public int solution(int[] info, int[][] edges) {
        int answer = 1;
        for(int i = 0; i < info.length; i++){
            list.add(new ArrayList<>());
        }
        visited = new boolean[info.length];

        for(int[] arr : edges){
            list.get(arr[0]).add(arr[1]);
        }

        bfs(info);

        System.out.println(sheepCount);


        return answer;
    }
    void bfs(int[] info){
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;

        while(!q.isEmpty()){
            int v = q.poll();
            for(Integer n : list.get(v)){
                if(visited[n]) continue;
                if(info[n] == 1){
                    q.offer(n);
                    sheepCount++;
                    visited[n] = true;
                }else{
                    if(wolfCount + 1 < sheepCount){
                        q.offer(n);
                        wolfCount++;
                        visited[n] = true;
                    }else{
                        q.offer(n);
                    }
                }
            }
        }
    }
}