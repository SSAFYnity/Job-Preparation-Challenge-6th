import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int len = msg.length();
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) map.put((char) (i+'A') + "", i+1);
        
        int s = 0;
        int e = 0;
        
        while (s <= e && e < len) {
            String str = msg.substring(s, e+1);
            if (!map.containsKey(str)) {
                list.add(map.get(msg.substring(s, e)));
                map.put(str, map.size() + 1);
                s = e;
            }
            e++;
        }
        
        String str = msg.substring(s, e);
        if (s < e && map.containsKey(str)) list.add(map.get(str));

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}