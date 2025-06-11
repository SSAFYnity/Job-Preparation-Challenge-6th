import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long dSquare = (long)d*d;
        
        for(long x = 0; x <= d; x+=k){
            long y = (long)Math.sqrt(dSquare - x*x);  // 좌표 하나가 주어지면 다른 좌표값도 주어짐.
            answer += (y/k)+1;  // 최대가 y인 값 중 k배 만족하는 좌표의 수
        }
        
        return answer;
    }
    

}