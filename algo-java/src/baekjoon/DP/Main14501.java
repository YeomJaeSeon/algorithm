package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Customer{
    int t;
    int p;
    int d;

    Customer(int t, int p, int d){
        this.t = t;
        this.p = p;
        this.d = d;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "t=" + t +
                ", p=" + p +
                ", d=" + d +
                '}';
    }
}

public class Main14501 {
    static int N;
    static List<Customer> list = new ArrayList<>();
    static int[] dp = new int[16];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i += 1){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            if(i + t > N) continue;
            list.add(new Customer(t, p, i + 1));
        }

//        dp[1] = list.stream().filter(i -> i.d == 1).mapToInt(i -> i.p);

        System.out.println(list);


    }
}
