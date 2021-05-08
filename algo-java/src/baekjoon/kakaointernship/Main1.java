package baekjoon.kakaointernship;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] roads = new int[][]{{1, 2, 3}, {3, 2, 3}};
        int[] traphs = new int[]{2};
        int result = solution.solution(3, 1, 3, roads, traphs);
        System.out.println(result);
    }
}
class Solution {
    public static int sum = 0;
    public static int[] traps;
    static boolean[] visited;
    static boolean reverseState;
    static List<Node>[] list;
    static List<Node>[] reverseList;

    public int solution(int n, int start, int end, int[][] roads, int[] trapsParam) {
        list = new List[n + 1]; // trap X
        reverseList = new List[n + 1]; // trap O

        traps = trapsParam;
        visited = new boolean[n + 1];

        for(int i = 0; i < n + 1; i++){
            list[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 0; j < roads.length; j++){
                if(roads[j][0] == i){
                    list[i].add(new Node(roads[j][1], roads[j][2]));
                }
                if(roads[j][1] == i){
                    reverseList[i].add(new Node(roads[j][0], roads[j][2]));
                }
            }
        }

        dfs(start);
        int answer = sum;

        return answer;
    }
    public static void dfs(int startNode){
        visited[startNode] = true;
        isTrap(startNode);
        if(reverseState){ // 정방향
            for (Node node : list[startNode]) {
                int nextNode = node.nextNode;
                int gravity = node.gravity;
                if(!visited[nextNode]){
                    sum += gravity;
                    dfs(nextNode);
                    }
                }
            }else{ //역방향
                for (Node node : reverseList[startNode]) {
                    int nextNode = node.nextNode;
                    int gravity = node.gravity;
                    if(!visited[nextNode]){
                        sum += gravity;
                        dfs(nextNode);
                    }
                }
            }
        }
    public static void isTrap(int targetNode){
        for (int trap : traps) {
            if(trap == targetNode){
                reverseState = !reverseState; // 함정 걸림 - 반대
            }
        }
    }
}
class Node{
    int nextNode;
    int gravity;
    Node(int nextNode, int gravity){
        this.nextNode = nextNode;
        this.gravity = gravity;
    }

    @Override
    public String toString() {
        return nextNode + ":" + gravity;
    }
}