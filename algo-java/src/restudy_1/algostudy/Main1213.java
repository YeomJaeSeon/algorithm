package restudy_1.algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1213 {
    static String englishName;
    static int[] alphabets = new int[26];
    static final int ASCII = 65;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        englishName = br.readLine();

        for(int i = 0; i < englishName.length(); i++){
            alphabets[(int)englishName.charAt(i) - ASCII]++;
        }

        if(isPelindrom()){
            System.out.println(makePelindrom());
        }else{
            System.out.println("I'm Sorry Hansoo");
        }

    }
    static boolean isPelindrom(){
        int oddCount = 0;
        for(int i = 0; i < alphabets.length; i++){
            if(alphabets[i] % 2 == 1) oddCount++;
        }

        if(oddCount == 0 || oddCount == 1){
            return true;
        }else{
            return false;
        }
    }
    static String makePelindrom(){
        StringBuilder preFix = new StringBuilder();
        StringBuilder suFFix = new StringBuilder();
        boolean isOddExist = false;
        char oddChar = ' ';

        for(int i = 0; i < alphabets.length; i++){
            if(alphabets[i] % 2 == 1){
                isOddExist = true;
                oddChar = (char)(i + ASCII);

                alphabets[i]--;
            }
            while(alphabets[i] % 2 == 0 && alphabets[i] > 0){
                preFix.append((char)(i + ASCII));
                suFFix.append((char)(i + ASCII));

                alphabets[i] -= 2;
            }
        }

        if(isOddExist){
            return preFix.toString() + oddChar + suFFix.reverse().toString();
        }else{
            return preFix.toString() + suFFix.reverse().toString();
        }
    }
}
