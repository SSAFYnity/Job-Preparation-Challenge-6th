import java.util.*;

class Solution {
    List<String> route = new ArrayList<>();
    boolean[] visited;
    boolean flag = false;
    
    public String[] solution(String[][] tickets) {
        // 1. 도착지 기준 정렬하기
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        visited = new boolean[tickets.length];  // 티켓 사용 여부
        // 2. 탐색하기       
        dfs("ICN", "ICN", 0, tickets);  // 현재 도착지 및 다음 출발지, 현재 경로, 탐색 수, 티켓 배열

        String [] answer = route.get(0).split(" ");
        return answer;
    }
    
    public void dfs(String current, String path, int count, String[][] tickets) {
        if(flag) return;
        
        if (count == tickets.length) {
            // 모든 경로 방문
            route.add(path);
            flag = true;     // 첫 번째 경로가 답
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                dfs(tickets[i][1], path + " " + tickets[i][1], count + 1, tickets);
                visited[i] = false;
            }
        }
    }
}