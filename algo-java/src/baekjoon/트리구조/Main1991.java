package baekjoon.트리구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//트리순회방법
// 전위 preOrder -> 루트, 좌자식, 우자식
// 중위 inOrder -> 좌자식, 루트, 우자식
// 후위 postOrder -> 좌자식, 우자식, 루트
public class Main1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] inputArr = new char[N][3];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            inputArr[i][0] = st.nextToken().charAt(0);
            inputArr[i][1] = st.nextToken().charAt(0);
            inputArr[i][2] = st.nextToken().charAt(0);
        }
        Arrays.sort(inputArr, new Compare());
        System.out.println(Arrays.deepToString(inputArr));
    }

}
class Compare implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        if(o1 instanceof Character[] && o2 instanceof Character[]){
            char[] c1 = (char[])o1;
            char[] c2 = (char[])o2;
            return c1[0] - c2[0];
        }
        return 0;
    }
}
