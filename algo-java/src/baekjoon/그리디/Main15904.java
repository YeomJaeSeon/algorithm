package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main15904 {
    static boolean[] ucpc = new boolean[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'U'){
                if(ucpc[0] == false){
                    ucpc[0] = true;
                }
            }else if(str.charAt(i) == 'C'){
                if(ucpc[0] == true && ucpc[1] == false){
                    ucpc[1] = true;
                }
                if(ucpc[2] == true && ucpc[3] == false){
                    ucpc[3] = true;
                    break;
                }
            }else if(str.charAt(i) == 'P'){
                if(ucpc[1] == true && ucpc[2] == false){
                    ucpc[2] = true;
                }
            }
        }
        boolean canUCPC = true;
        for(int i = 0; i < 4; i++){
            if(!ucpc[i]){
                canUCPC = false;
                break;
            }
        }
        if(canUCPC){
            System.out.println("I love UCPC");
        }else{
            System.out.println("I hate UCPC");
        }
    }
}

/**
 UCPC가 되려면
 대문자 U, C, P, C가 순서대로 존재하기만하면된다.
 UPPPPCCUUPCPCPC
 이건 UCPC일까?
 U, C, P, C가순서대로 존재하는 경우가 있기 떄문에 맞다

 풀이
 boolean배열을 하나선언함
 이는 UCPC가 가능한지 아닌지의 여부를 저장혈고
 0은 U,1은 C, 2는 P, 3은 C

 P이려면 visited[1] == true이고
 visied[2] == false여야 한다.
 이런식으로
 UCPC를 만났을 때 이전 boolean배열의 여부를 확인해서 순서를 결정함

 **/