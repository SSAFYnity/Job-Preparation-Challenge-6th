import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = convert(m);     // # 처리
        
        int maxTime = 0;
        for(int i = 0; i < musicinfos.length; i++){
            String [] tmp = musicinfos[i].split(",");
            int playTime = getTime(tmp[0], tmp[1]);     // 재생 시간
            String oriMelody = convert(tmp[3]);    // 기본 멜로디 라인
            String curMelody = getMelody(playTime, oriMelody);  // 재생시간 동안의 멜로디 
            
            if(curMelody.contains(m)){
                if(playTime > maxTime){
                    maxTime = playTime;     // 재생 시간 최댓값 갱신
                    answer = tmp[2];
                }
            }
        }
        
        return answer;
    }
    
    String convert(String str){
        // # 변환하기
        return str.replaceAll("C#", "c")
            .replaceAll("D#", "d")
            .replaceAll("F#", "f")
            .replaceAll("G#", "g")
            .replaceAll("A#", "a")
            .replaceAll("B#", "b");
    }
    
    int getTime(String startTime, String endTime){
        String [] start = startTime.split(":");
        String [] end = endTime.split(":");
        
        int hour = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
        int min = Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
        
        return hour*60+min;
        
    }
    
    String getMelody(int time, String oriMelody){
        StringBuilder sb = new StringBuilder();
        int length = oriMelody.length();
        
        for(int i = 0; i < time; i++){
            sb.append(oriMelody.charAt(i%length));
        }
        
        return sb.toString();
    }

}