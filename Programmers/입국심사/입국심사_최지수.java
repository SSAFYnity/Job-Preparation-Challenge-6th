import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        long s = 1;
        long lim = (long) Arrays.stream(times).max().getAsInt() * n;
        long e = lim;
        long p = (s+e)/2;
        
        while (s <= e && e <= lim) {
            p = (s+e)/2;
            long temp = 0;
            for (int t : times) temp += (p / t);
            if (temp >= n) e = p-1;
            else s = p+1;
        }
        
        return s;
    }
}