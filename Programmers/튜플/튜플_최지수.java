import java.util.*;

class Solution {
    boolean isDigit(char c) {return c >= '0' && c <= '9';}
    public int[] solution(String s) {
        List<List<Integer>> list = new ArrayList<>();
        int len = s.length();
        for (int i = 1; i < len-1; i++) {
            char c = s.charAt(i);
            if (c == '{') list.add(new ArrayList<>());
            else if (isDigit(c)) {
                int num = c - '0';
                for (int j = i+1; j < len-1; j++) {
                    char z = s.charAt(j);
                    if (isDigit(s.charAt(j))) num = (num * 10) + (s.charAt(j) - '0');
                    else {
                        list.get(list.size()-1).add(num);
                        if (z == '}') i = j+1;
                        else i = j;
                        break;
                    }
                }
            }
        }
        int[] answer = new int[list.size()];
        Collections.sort(list, (o1, o2) -> {return o1.size() - o2.size();});
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : list.get(list.size()-1)) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        HashMap<Integer, Integer> pre = new HashMap<>();
        
        for (int i = 0; i < list.size(); i++) {
            HashMap<Integer, Integer> now = new HashMap<>();
        
            for (int j : list.get(i)) {
                if (now.getOrDefault(j, 0) < pre.getOrDefault(j, 0)) {
                    now.put(j, now.getOrDefault(j, 0)+1);
                } else {
                    pre.put(j, pre.getOrDefault(j, 0)+1);
                    answer[i] = j;
                    break;
                }
            }
        }
        return answer;
    }
}