import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 놀러오는 친구 수
        int K = Integer.parseInt(st.nextToken());  // 성냥 수
        int[] enter = new int[N];
        for (int i = 0; i < N; i++) {
            enter[i] = Integer.parseInt(br.readLine());  // 친구 들어오는 시간
        }

        // 친구 체류 시간
        int[][] intervals = new int[N][2];
        for (int i = 0; i < N; i++) {
            intervals[i][0] = enter[i];
            intervals[i][1] = enter[i] + 1;
        }

        // 전체 구간 시간 계산
        int totalTime = 0;
        for (int[] itv : intervals) {
            totalTime += (itv[1] - itv[0]);
        }

        // 공백 시간
        ArrayList<Integer> gaps = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            int gap = intervals[i][0] - intervals[i - 1][1];  // 공백시간
            gaps.add(gap);
        }

        Collections.sort(gaps);  // 공백 짧은 순으로 정렬하여 큰 gap을 최대한 없애기
        
        int mergeCount = N - K;
        for (int i = 0; i < mergeCount; i++) {
            totalTime += gaps.get(i);  // 갭 제거시 난로 켜놓음
        }

        System.out.println(totalTime);


    }
}
