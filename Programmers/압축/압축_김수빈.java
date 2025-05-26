import java.util.*;

class Solution {
    public int[] solution(String msg) {
        // 기본 색인
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            String alphabet = String.valueOf((char) (i + 64));
            map.put(alphabet, i);
        }

        int index = 27;  // 마지막 색인
        List<Integer> list = new ArrayList<>();  // 답 리스트

        int n = msg.length();
        int begin = 0;
        int end = 1;

        while (begin < n && end <= n) {
            String tempStr = msg.substring(begin, end);
            if (!map.containsKey(tempStr)) {
                String printStr = msg.substring(begin, end - 1);
                list.add(map.get(printStr));
                map.put(tempStr, index++);
                begin = end - 1;
                continue;
            }
            end++;
        }

        if (begin < n) {
            String tempStr = msg.substring(begin, n);
            if (map.containsKey(tempStr)) {
                list.add(map.get(tempStr));
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
