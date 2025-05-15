import java.util.*;

/*
아이디어: 시간을 이분탐색

*/
class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = 0;
        for(int time : times){
            if((long)time*n > right) right = (long)time*n;  // 제일 오래 걸리는 심사관으로 설정
        }
        long answer = right;    // 큰 값으로 초기 설정
        
        Arrays.sort(times);
        
        long mid = 0;
        while(left <= right){
            mid = (left+right)/2;
            
            long cnt = 0;    // mid 안에 심사받는 사람 수
            for(int i = 0; i < times.length; i++){
                cnt += (mid/times[i]);  // mid시간 동안, times[i]로 심사 가능한 사람 수
                
            }
            
            if(cnt >= n){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }  

        return answer;
    }
}