import java.util.*;

/*
아이디어: 백트래킹
포인트: 해당 점수를 라이언이 가져가냐 vs 안 가져가냐 -> 안 가지면 화살 사용 아예 X
*/
class Solution {
    int [] info;
    int len;
    int[] answer;
    int maxDiff = 0;
    public int[] solution(int n, int[] info) {
        this.info = info;
        len = info.length;
        
        answer =new int[len]; 
        
        backtracking(n, 0, new int[len]);
        
        if(maxDiff == 0) return new int[]{-1};
        else return answer;
    }
    
    void backtracking(int cnt, int idx, int [] lionInfo){
        // 가지치기 조건 -> 판별하려는 점수다 탐색 -> 0점 도달
        if(idx == len){
            // 라이언의 화살이 아직 남은 경우
            if(cnt > 0){
                // 0점에 몰아주기(n발 전부 소진해야함)
                lionInfo[len-1] += cnt;
            }
            
            // 어피치, 라이언 점수 계산
            int apeachScore = 0;
            int lionScore = 0;
            for(int i = 0; i < len; i++){
                if(lionInfo[i] == 0 && info[i] == 0) continue;  // 둘 다 쏘지 않음
                
                if(lionInfo[i] > info[i]) lionScore += (len-i-1);
                else apeachScore += (len-i-1);
            }
            
            // 어피치, 라이언 점수차
            int diff = lionScore - apeachScore;
            if(diff > 0){
                // 라이언 승
                if(diff > maxDiff || (diff == maxDiff) && check(lionInfo)){
                    maxDiff = diff; // 점수 차 갱신
                    answer = lionInfo.clone();  // 깊은복사로 answer 갱신
                }
            }

            if(cnt > 0) lionInfo[len-1] -= cnt;     // 화살 수 상태 복원
            
            return;
        }
        
        // 라이언이 점수를 가져가는 경우
        if(cnt >= info[idx]+1){
            lionInfo[idx] = info[idx]+1;  // 어피치보다 1발 더 많아야 점수 획득
            backtracking(cnt - lionInfo[idx], idx + 1,  lionInfo);
            lionInfo[idx] = 0; // 원래 상태로 초기화
        }
        
        // 라이언이 점수를 안 가져가는 경우 -> 화살 안 쏨
        backtracking(cnt, idx+1, lionInfo);
    }
    
    boolean check(int [] lionInfo){
        for(int i = len-1; i >= 0; i--){
            if(lionInfo[i] > answer[i]) return true;
            else if(lionInfo[i] < answer[i]) return false;
        }
        
        return false;   // 모두 같을 경우
    }
}