import java.util.*;
/*
아이디어: 그리디? 백트래킹?(동전 문제와 유사한 느낌)
*/ 
class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        //끝자리부터 판별 -> 4이하(내림), 5이상(올림) -> 이때, 5일경우에는 앞자리가 5이상일때만 올리기
        while(storey > 0){
            int num = storey % 10;  // 끝짜리 추출
            int nextNum = (storey/10) % 10;     // 앞자리 추출
            
            if(num > 5 || (num == 5 && nextNum >= 5)){  
                answer += (10-num);
                storey += 10;       // 올림 처리 
            }else{
                answer += num;
            }
            storey /= 10;
        }
        
        return answer;
    }
}