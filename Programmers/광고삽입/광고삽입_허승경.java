import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = changeTime(play_time);   // 전체 영상 길이 -> 초로 변환
        int advTime = changeTime(adv_time);     // 광고 영상 길이 -> 초로 변환 
        
        int [] time = new int[360000];
        
        //  1. 시간 변환하기
        for(String log : logs){
            String [] tmp = log.split("-"); // - 기준으로 분리
            int start = changeTime(tmp[0]);
            int end = changeTime(tmp[1]);
            
            for(int i = start; i < end; i++) {
                time[i]++;
            }
        }
        
        long totalCnt = 0;
        for(int i = 0; i < advTime; i++){   // 0초에 광고 틀었을 때, 누적 시청자 수 구하기
            totalCnt += time[i];
        }
        
        int maxIdx = 0;
        long maxTotalCnt = totalCnt;
        for(int i = advTime; i < playTime; i++){
            totalCnt += time[i] - time[i-advTime];  // 오른쪽으로 1초씩 밀면서 누적 시청자 수 구하기
            
            if(totalCnt > maxTotalCnt){    // 시청자 수 갱신하기
                maxTotalCnt = totalCnt;
                maxIdx = i - advTime + 1;
            }
        }
        
        return changeResult(maxIdx);
    }
    
    int changeTime(String ori){
        String [] time = ori.split(":");
        
        int hour = Integer.parseInt(time[0])*3600;
        int min = Integer.parseInt(time[1])*60;
        int sec = Integer.parseInt(time[2]);
        
        return hour+min+sec;
    }
    
    String changeResult(int time){
        int hour = time/3600;
        time -= hour*3600;
        int min = time/60;
        time -= min*60;
        
        StringBuilder sb = new StringBuilder();
        if(hour < 10) sb.append("0"+hour+":");
        else sb.append(hour+":");
        
        if(min < 10) sb.append("0"+min+":");
        else sb.append(min+":");
        
        if(time < 10) sb.append("0"+time);
        else sb.append(time);
        
        return sb.toString();
    }
}