import java.util.*;

class Solution {
    HashMap<String, ArrayList<String>> map = new HashMap<>();
    HashMap<String, Integer> countmap = new HashMap<>();
    ArrayList<String> list = new ArrayList<>();
    String[] answer;
    boolean ok;
    int n;
    void dfs(String now) {
        if (ok) return;
        if (!map.containsKey(now) || countmap.get(now) == 0) {
            if (list.size() == n+1) {
                answer = new String[list.size()];
                int idx = 0;
                for (String str : list) answer[idx++] = str;
                ok = true;
            }
            return;
        }
        
        for (int i = 0; i < map.get(now).size(); i++) {
            if (map.get(now).get(i) == null) continue;
            String temp = map.get(now).get(i);
            map.get(now).set(i, null);
            list.add(temp);
            countmap.put(now, countmap.get(now)-1);
            dfs(temp);
            list.remove(list.size()-1);
            countmap.put(now, countmap.get(now)+1);
            map.get(now).set(i, temp);
        }
        
    }
    public String[] solution(String[][] tickets) {    
        n = tickets.length;
        
        for (String[] arr : tickets) {
            if (!map.containsKey(arr[0])) map.put(arr[0], new ArrayList<>());
            map.get(arr[0]).add(arr[1]);
            countmap.put(arr[0], countmap.getOrDefault(arr[0], 0)+1);
        }
        
        for (String str : map.keySet()) Collections.sort(map.get(str));
        
        list.add("ICN");
        dfs("ICN");
        
        return answer;
    }
}