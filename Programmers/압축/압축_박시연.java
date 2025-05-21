import java.util.*;

class Solution {
    public int[] solution(String msg) {
        // 사전 초기화: A~Z를 1~26까지 매핑
        Map<String, Integer> dictionary = new HashMap<>();
        int dictSize = 26;
        for (int i = 1; i <= 26; i++) {
            dictionary.put(String.valueOf((char)(i + 'A' - 1)), i);
        }

        List<Integer> output = new ArrayList<>();
        int idx = 0;

        while (idx < msg.length()) {
            int length = 1;
            // 가장 긴 문자열 w 찾기
            while (idx + length <= msg.length() && dictionary.containsKey(msg.substring(idx, idx + length))) {
                length++;
            }
            // length가 1 증가된 상태이므로 한 글자 줄임
            length--;

            String w = msg.substring(idx, idx + length);
            output.add(dictionary.get(w));

            // 다음 글자 c 존재하면 w+c를 사전에 등록
            if (idx + length < msg.length()) {
                String wc = msg.substring(idx, idx + length + 1);
                dictSize++;
                dictionary.put(wc, dictSize);
            }
            idx += length;
        }
        
        int[] answer = output.stream().mapToInt(i -> i).toArray();

        // List<Integer>를 int[]로 변환
        return answer;
    }
}