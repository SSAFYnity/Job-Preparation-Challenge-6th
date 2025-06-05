import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> collatz = new ArrayList<>();  // 우박 수열
        collatz.add(k);
        while (k != 1) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            collatz.add(k);
        }
        double[] areaSum = new double[collatz.size()];
        for (int i = 1; i < collatz.size(); i++) {
            double area = (collatz.get(i - 1) + collatz.get(i)) / 2.0;
            areaSum[i] = areaSum[i - 1] + area;
        }

        int n = collatz.size() - 1;
        
        double[] answer = new double[ranges.length];
        int idx = 0;
        
        for (int i = 0; i < ranges.length; i++) {
            
            int a = ranges[i][0];
            int b = n + ranges[i][1];

            if (a > b) {
                answer[i] = -1.0;
            } else {
                answer[i] = (double) areaSum[b] - areaSum[a];
            }
        }
        
        return answer;
    }
}
