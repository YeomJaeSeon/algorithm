package baekjoon.구현;

import java.io.*;
import java.util.Arrays;

public class Main9081_2 {
    static int T;
    static String original;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            original = br.readLine();
            char[] charArr = original.toCharArray();

            int[] intArr = new int[charArr.length];
            for(int j = 0; j < charArr.length; j++){
                intArr[j] = (int)charArr[j] - 65;
            }

            int idx = -1;
            int idx2= -1;

            outer:
            for(int j = original.length() - 1; j >= 1; j--){
                for(int k = j - 1; k >= 0; k--){
                    if(intArr[j] > intArr[k]){
                        //감소하는 부분 찾기
                        idx = k;
                        idx2 = j;
                        break outer;
                    }
                }
            }
            if(idx == -1){
                bw.write(original+"\n");
            }else{
                int tmp = intArr[idx];
                intArr[idx] = intArr[idx2];
                intArr[idx2] = tmp;

                int[] subArr = new int[intArr.length - 1 - idx];

                for(int j = idx + 1; j < intArr.length; j++){
                    subArr[j - (idx + 1)] = intArr[j];
                }
                Arrays.sort(subArr);
                for(int j = idx + 1; j < intArr.length; j++){
                    intArr[j] = subArr[j - (idx + 1)];
                }

                for(int j = 0; j < intArr.length; j++){
                    bw.write((char)(intArr[j] + 65));
                }
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
