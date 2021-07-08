package baekjoon.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main17609 {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            //test case
            String str = br.readLine();
            if(isPalindrome(str)){
                //펠린드롬
                System.out.println(0);
            }else{
                if(isSimilarPalindrome(str)){
                    //유사펠린드롬
                    System.out.println(1);
                }else{
                    //일반 문자열
                    System.out.println(2);
                }
            }
        }
    }
    static boolean isPalindrome(String str){
        for(int i = 0; i < str.length() / 2; i++){
            if(str.charAt(i) != str.charAt(str.length() - i - 1)) return false;
        }
        return true;
    }
    static boolean isSimilarPalindrome(String str){
        boolean isChange = true;
        boolean isChange2 = true;
        boolean isOk1 = true;
        boolean isOk2 = true;
        int start = 0;
        int end = str.length() - 1;
        int start2 = 0;
        int end2 = str.length() -1;
        //다른게나오면 start를  ->
        while(start <= end){
            if(str.charAt(start) == str.charAt(end)){
                start++;
                end--;
            }else{
                if(!isChange) {
                    isOk1 = false;
                    break;
                }
                if(str.charAt(start + 1) == str.charAt(end)){
                    //start를 오른쪽으로
                    start++;
                    isChange = false;
                }else{
                    isOk1 = false;
                    break;
                }
                start++;
                end--;
            }
        }
        // 다른게 나오면 end를 <-
        while(start2 <= end2){
            if(str.charAt(start2) == str.charAt(end2)){
                start2++;
                end2--;
            }else{
                if(!isChange2) {
                    isOk2 = false;
                    break;
                }
                if(str.charAt(start2) == str.charAt(end2 -1)){
                    //end를 왼쪾으로
                    end2--;
                    isChange2 = false;
                }else{
                    isOk2 = false;
                    break;
                }
                start2++;
                end2--;
            }
        }
        if(isOk1 || isOk2){
            return true;
        }else{
            return false;
        }
    }
}

/**
 펠린드롬 찾기이다.
 펠린드롬 찾기는 왼쪽에서 오른쪽으로, 오른쪼게서 왼쪽으로 이동하는 포인터 하나만사용하면된다.

 그러나 유사펠린드롬은?
 그렇지않다. 하나를 삭제했을때 펠린드롬이냐 아니냐를 판단하기위해서는 포인터두개를 만들어서
 각 포인터가 가르키는 문자가 다를경우 왼쪽포인터를 오른쪽으로 옮길거냐, 오른쪽포인터를 왼쪾으로 옮길거냐
 두가지 경우중 한가지만 행해야한다.

 그렇기 위해서는 하나의 문자열에 대해서 두개의 행동이 이루어져야한다.
 하나의 행동으로 조건문안에서 if(오른쪽껄 왼쪾으로 ) else(왼쪾걸 오른쪽으로)하면
 둘중 하나의 행동밖에이루어지지않는다.

 난 isSimilarPalindrom 메서드내에 두개의 while문으로 다른문자가 나올시
 왼쪽 포인터를 옮길거냐? 오른쪽포인터를 옮길거냐를 구현했따.

 내가 이 문제점을 알아낸 반례로는
 1
 baaba
 이다.
 첫번재 문자 b와 막문자 a가 다른데
 start를  ++할지 end를 --할지에대한 고민이있었다.
 ++하면, a a로 같지만 유사펠린드롬이아닌데 end를 --하면 유사펠린드롬이기때문이다.
 이 반례때문에 메서드 내에서 두개의 반복문을 이용했따.

 **/