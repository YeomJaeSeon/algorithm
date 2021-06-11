package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Grade{
    private int test1;
    private int test2;

    public Grade(int test1, int test2){
        this.test1 = test1;
        this.test2 = test2;
    }

    public int getTest1() {
        return test1;
    }

    public int getTest2() {
        return test2;
    }
}

public class Main1946 {
    static int T;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) solve();
    }
    static void solve() throws IOException{
        int N = Integer.parseInt(br.readLine());
        int result = N;
        Grade minGrade = new Grade(0, 100001);
        List<Grade> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            list.add(new Grade(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list, new SortTest1());
        for(int i = 1; i < N; i++){
            minGrade = minGrade.getTest2() > list.get(i - 1).getTest2() ? list.get(i - 1) : minGrade;
            if(minGrade.getTest2() < list.get(i).getTest2()){
                result--;
            }
        }
        System.out.println(result);
    }
}
class SortTest1 implements Comparator<Grade>{

    @Override
    public int compare(Grade o1, Grade o2) {
        return o1.getTest1() - o2.getTest1(); // test1
    }
}

/**
 서류시험 점수 오름차순정렬한뒤
 해당 컬렉션 하나씩 탐색하면서
 그전까지의 면접점수 최소인 녀석을 갱신해가며
 최소 면접점수인 사람보다 큰 면접점수를 가진사람이있으면 하나씩빼면서
 구했음

 시간초과
 서류시험 점수 오름차순으로 정렬한뒤
 0 ~ i - 1지원자의 면접점수를 i번째 면접점수와 하나씩 다비교함 O(N^2)
 그러나
 0 ~ i - 1 지원자의 면접점수 최소인 지원자를 갱신해가면
 O(N)으로 구할수있음

 **/