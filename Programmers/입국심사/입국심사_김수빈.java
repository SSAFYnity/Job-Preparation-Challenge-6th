import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long a = 1;
        long b = (long) times[times.length - 1] * n;
        long answer = 0;
        
        while (a <= b) {
            long possibleNum = 0;
            long mid = (a + b) / 2;
            
            for (int time : times) {
                possibleNum += mid / time;
            }
            
            if (possibleNum >= n) {
                b = mid - 1;
                answer = mid;
            } else {
                a = mid + 1;
            }
            
        }
        return answer;
    }
}
