import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> list = new ArrayList<>();
        
        list.add(k);    // 시작점 추가
        // 1. 우박 수열 생성
        while(k > 1){
            if(k%2 == 0) k = k/2;
            else k = (k*3) + 1;
            
            list.add(k);
        }
        
         for(int i = 0; i < ranges.length; i++){
            // 1. 각 ranges[i]에 대한 그래프 넓이 구하기
            if(ranges[i][0] > ranges[i][1] + list.size() - 1){
                answer[i] = -1;
                continue;
            }else if(ranges[i][0] == ranges[i][1] + list.size() - 1){
                answer[i] = 0;
                continue;
            }
            
            double res = 0;

            for(int j = ranges[i][0]; j < ranges[i][1] + list.size() - 1; j++){
                res += (list.get(j) + list.get(j + 1)) / 2.0;   // 사다리꼴 넓이 계산하기
            }
            
            answer[i] = res;
        }
        
        return answer;
    }
}