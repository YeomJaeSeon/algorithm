package back_dev;

public class Main1 {
    static String tempStr;
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"bird100", "bird101", "bird102", "gotoxy"},
        "bird100"));

    }
    static String solution(String[] registered_list, String new_id){
        while(isAlreadyExisted(registered_list, new_id)){
            //이미 존재하면 계속 아이디 추천해줘야함.
            int boundary = -1;
            for(int i = 0; i < new_id.length(); i++){
                if(new_id.charAt(i) >= '1' && new_id.charAt(i) <= '9') {
                    boundary = i;
                    break;
                }
            }
            StringBuilder firstSb = new StringBuilder();
            StringBuilder secondSb = new StringBuilder();

            //S N 분할하는 작업
            if(boundary == -1){
                //S로만 이루어짐
                System.out.println("S로만 이루어짐");
                for(int i = 0; i < new_id.length(); i++)
                    firstSb.append(new_id.charAt(i));

                secondSb.append('0');
           }else{
                //N도 있음
                System.out.println("S와 N 으로 이루어짐");
                for(int i = 0; i < boundary; i++){
                    firstSb.append(new_id.charAt(i));
                }
                for(int i = boundary; i < new_id.length(); i++){
                    secondSb.append(new_id.charAt(i));
                }
            }

            System.out.println(firstSb.toString());
            System.out.println(secondSb.toString());

            int N = Integer.parseInt(secondSb.toString());
            N++;
            new_id = firstSb.toString() + N;
            System.out.println("new_id = " + new_id);
        }


        return new_id;
    }
    static boolean isAlreadyExisted(String[] registered_list, String new_id){
        for (String id : registered_list) {
            if(id.equals(new_id)) return true;
        }
        return false;
    }
}
