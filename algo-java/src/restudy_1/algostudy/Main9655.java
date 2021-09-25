package restudy_1.algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9655 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N % 2 == 0){
            System.out.println("CY");
        }else{
            System.out.println("SK");
        }
    }

}


/**
 * 5
 * 1 1 1 1 1
 * s c s c s
 * 1 1 3
 * s c s
 * 1 3 1
 * s c s
 * 3 1 1
 * s c s
 *
 * 6
 * 1 1 1 3
 * s c s c
 * 1 1 1 1 1 1
 * s c s c s c
 * 3 3
 * s c
 */
