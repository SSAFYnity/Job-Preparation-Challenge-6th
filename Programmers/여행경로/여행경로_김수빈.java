import java.util.*;

public class Solution {
    static List<String> answer;
    static boolean[] used;

    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        List<String> route = new ArrayList<>();
        used = new boolean[tickets.length];

        // 티켓을 사전순으로 정렬
        Arrays.sort(tickets, Comparator.comparing(a -> a[1]));

        route.add("ICN");
        dfs("ICN", tickets, route, 0);

        return answer.toArray(new String[0]);
    }

    public boolean dfs(String current, String[][] tickets, List<String> route, int usedCount) {
        if (usedCount == tickets.length) {
            answer = new ArrayList<>(route); // 경로 저장
            return true; // 경로 완성되었으니 리턴
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!used[i] && tickets[i][0].equals(current)) {
                used[i] = true;
                route.add(tickets[i][1]);
                if (dfs(tickets[i][1], tickets, route, usedCount + 1)) return true;
                route.remove(route.size() - 1);
                used[i] = false;
            }
        }

        return false;
    }
}
