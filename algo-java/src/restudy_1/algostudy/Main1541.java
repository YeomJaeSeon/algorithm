package restudy_1.algostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main1541 {
    static String expression;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        expression = br.readLine();

        String[] subExpression = expression.split("-");

        for(String str : subExpression){
            String[] plusExpression = str.split("\\+");
            int sum = Arrays.stream(plusExpression).mapToInt(Integer::parseInt).sum();

            result.add(sum);
        }

        if(result.size() > 1){
            int sum = 0;
            sum += result.get(0);
            for(int i = 1; i < result.size(); i++){
                sum -= result.get(i);
            }
            System.out.println(sum);
        }else{
            System.out.println(result.get(0));
        }
    }
}
