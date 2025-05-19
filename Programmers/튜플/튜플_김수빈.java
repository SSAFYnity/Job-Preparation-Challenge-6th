import java.util.*;

class Solution {
    public int[] solution(String s) {
        int n = s.length();
        int maxLen = 0;
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, int[]> map = new HashMap<>();

        for (int i = 1; i < n - 1; i++) {
            char ch = s.charAt(i);
            if (ch == '{') {
                int len = list.size();
                if (len == 0) {
                    continue;
                }
                int[] arr = new int[len];
                for (int j = 0; j < len; j++) {
                    arr[j] = list.get(j);
                }
                if (maxLen < len) {
                    maxLen = len;
                }
                map.put(len, arr);
                list.clear();
            } else if (Character.isDigit(ch)) {
                sb.append(ch);
            } else if (ch == ',') {
                int num = Integer.parseInt(sb.toString());
                list.add(num);
                sb = new StringBuilder();
            } else if (ch =='}' && s.charAt(i + 1) == '}') {
                int num = Integer.parseInt(sb.toString());
                list.add(num);
                int len = list.size();
                int[] arr = new int[len];
                for (int j = 0; j < len; j++) {
                    arr[j] = list.get(j);
                }
                if (maxLen < len) {
                    maxLen = len;
                }
                map.put(len, arr);
            }
        }

        int[] answer = new int[maxLen];
        HashSet<Integer> checkSet = new HashSet<>();

        for (int i = 1; i <= maxLen; i++) {
            int[] values = map.get(i);
            for (int value : values) {
                if (!checkSet.contains(value)) {
                    answer[i - 1]  = value;
                    checkSet.add(value);
                }
            }
        }
        return answer;
    }
}
