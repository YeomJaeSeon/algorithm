package baekjoon.구현;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main11723_set {
    static int M;
    static Set<Integer> set = new HashSet<>();
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String method = st.nextToken();
            if(st.hasMoreTokens()){
                //add remove check toggle
                int value = Integer.parseInt(st.nextToken());
                caculation(method, value);
            }else{
                //all or empty
                caculation(method);
            }
        }

        bw.flush();
        bw.close();
    }
    static void caculation(String method, int ...value) throws IOException {
        if(method.equals("add")){
            int v = value[0];
            set.add(v);
        }else if(method.equals("remove")){
            int v = value[0];
            set.remove(v);
        }else if(method.equals("check")){
            int v = value[0];
            if(set.contains(v)){
                bw.write(1 + "\n");
            }else{
                bw.write(0 + "\n");
            }
        }else if(method.equals("toggle")){
            int v = value[0];
            if(set.contains(v)){
                set.remove(v);
            }else{
                set.add(v);
            }
        }else if(method.equals("all")){
            for(int i = 1; i <= 20; i++){
                set.add(i);
            }
        }else if(method.equals("empty")){
            set.clear();
        }
    }
}
