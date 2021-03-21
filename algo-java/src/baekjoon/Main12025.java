package baekjoon;

import java.util.Scanner;

public class Main12025 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        // 영훈이가 입력한값

        long k = scanner.nextLong();

        String first = "";
        
        int cnt = 0; // 1, 2, 6, 7 개수

        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '6') {
                first += 1;
                ++cnt;
            }
            else if(input.charAt(i) == '7') {
                ++cnt;
                first += 2;
            }
            else first += input.charAt(i);

            if(input.charAt(i) == '1') ++cnt;
            else if(input.charAt(i) == '2') ++cnt;
        }

        long checkCnt = 1;
        for(int i = 0; i < cnt; i++) checkCnt *= 2;
        if(checkCnt == 1) System.out.println(input);
        else if(k - 1 >= checkCnt) System.out.println(-1);
        else{
            String bNum = Long.toBinaryString(k - 1);

            String result = "";
            for(int i = first.length() - 1; i >= 0; i--){
                if(first.charAt(i) == '1'){
                    if(bNum.length() > 0) {
                        if (bNum.charAt(bNum.length() - 1) == '1') {
                            result += 6;
                        } else {
                            result += 1;
                        }
                        bNum = bNum.substring(0, bNum.length() - 1);
                    }
                    else result += first.charAt(i);
                }else if(first.charAt(i) == '2'){
                    if(bNum.length() > 0) {
                        if (bNum.charAt(bNum.length() - 1) == '1') {
                            result += 7;
                        } else {
                            result += 2;
                        }
                        bNum = bNum.substring(0, bNum.length() - 1);
                    }
                    else result += first.charAt(i);
                }else result += first.charAt(i);
            }
            String realResult = "";
            for(int i = result.length() - 1; i >= 0; i--){
                realResult += result.charAt(i);
            }
            System.out.print(realResult);

        }
    }
}
