import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(String time : timetable){
            String [] tmp = time.split(":");
            pq.add(Integer.parseInt(tmp[0])*60 + Integer.parseInt(tmp[1]));   // 분으로 변환
        }
        
        int target = 9*60;  // 기준 시간(09:00);
        
        for(int i = 0; i < n-1; i++){
            int cnt = 0;
            while(!pq.isEmpty()){
                if(cnt >= m) break;
                if(pq.peek() > target) break;
                
                pq.poll();
                cnt++;
            }
            target += t;
        }
        
        // 막차 구하기
        int crewNum = 0;    // 막차 탄 인원수
        int lastTime = 0;   // 마지막 탑승 시간
        while(!pq.isEmpty() && pq.peek() <= target && crewNum < m){
            lastTime = pq.poll();
            crewNum++;
        }
        
        int result = 0;
        if(crewNum < m){
            result = target;
        }else{
            result = lastTime -1;
        }
        
        // 정답 변환
        String hour = String.valueOf(result/60);
        String min = String.valueOf(result%60);
        
        StringBuilder sb = new StringBuilder();
        if(hour.length() == 1){
            sb.append("0"+hour+":");
        }else sb.append(hour+":");
        
        
        if(min.length() == 1){
            sb.append("0"+min);
        }else sb.append(min);
        
        return sb.toString();
    }
}