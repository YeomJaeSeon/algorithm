package baekjoon.트리구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//트리순회방법
// 전위 preOrder -> 루트, 좌자식, 우자식
// 중위 inOrder -> 좌자식, 루트, 우자식
// 후위 postOrder -> 좌자식, 우자식, 루트
public class Main1991 {
    public static char[][] tree;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new char[N][3];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            tree[i][0] = st.nextToken().charAt(0);
            tree[i][1] = st.nextToken().charAt(0);
            tree[i][2] = st.nextToken().charAt(0);
        }
        // 0 -> 1 -> 2
        preOrder(0, tree[0]);
    }
    public static void preOrder(int nodeNum, char[] node){
        char root = node[0];
        char left = node[1];
        char right = node[2];
        System.out.print(root);
        visited[nodeNum] = true;
        for(int i = 0; i < tree.length; i++){
            if(tree[i][1] == root && !visited[i]) preOrder(i, tree[i]);
        }
        for(int i = 0; i < tree.length; i++){
            if(tree[i][2] == root && !visited[i]) preOrder(i, tree[i]);
        }
    }
}