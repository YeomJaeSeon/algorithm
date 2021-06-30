package programmers;

import java.util.Stack;

public class 크레인_인형뽑기_게임 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4}));
    }
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }


        for(int i = 0; i < moves.length; i++){
            int point = moves[i];

            for(int j = 0; j < board.length; j++){
                if(board[j][point - 1] != 0){
                    if(!stack.isEmpty() && stack.peek() == board[j][point - 1]){
                        stack.pop(); // 삭제
                        answer += 2; //추가되는것, 이미존재하는것 총 두개삭제됨
                    }else{
                        stack.push(board[j][point - 1]); // 스택에 추가
                    }
                    board[j][point - 1] = 0; // 0으로 집었으니 다시 비워줘야함

                    break; // 찾으면 break해서 위에서부터 찾는 동작 멈추기
                }
            }
        }
        return answer;
    }
}
/**
 * 2차원배열 index를 써가면서 확인했고
 * moves배열의 첫번째부터 집을 위치를 2차원배열에 적용함
 * 맨위부터 0이 아닌게 나오면
 * 그걸 stack에 넣는식으로
 * stack에 넣으려하는데 이미 맨위에 같은 값이 있으면 deletCnt를 늘려주는 식으로 품
 *
 * 그리고 stack은 처음에 비어잇으므로 비어있지않으면이라는 조건을 넣어줘야하고
 * 그리고 집게로 인형집었으면 다시 0으로 바꿔주며 비워주는 것이필요함
 *
 * 전형적인 구현문제임
 * stack을 이용해서 쉽게품
 */
