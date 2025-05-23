import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int boxIdx = 1;    //  상자 순서
        int orderIdx = 0; // 박스 순서
        Stack<Integer> stack = new Stack<>();       // 보조 컨베이어 벨트
        
        
        while(orderIdx < order.length){
            if(order[orderIdx] == boxIdx){
                answer++;
                orderIdx++;
                boxIdx++;
            }else{
                // 1. 보조 컨베이어 벨트에 추가하기
                while(boxIdx <= order[orderIdx]){
                    stack.add(boxIdx++);
                }
                
                // 2. 보조 컨베이어 벨트의 마지막 삽입값과 일치 여부 확인
                if(stack.peek() == order[orderIdx]){
                    stack.pop();
                    answer++;
                    orderIdx++;
                }else break;
            }
        }

        return answer;
    }
}