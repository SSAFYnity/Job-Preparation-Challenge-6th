import java.util.*;
import java.io.*;

public class Main {
    // 4, 6, 9, 11 -> 30일
    // 1, 3, 5, 7, 8, 10, 12 -> 31일
    // 2 -> 28일
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] startDate = new int[N][2];
        int[][] endDate = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            startDate[i][0] = Integer.parseInt(st.nextToken());  // 시작월
            startDate[i][1] = Integer.parseInt(st.nextToken());  // 시작일
            endDate[i][0] = Integer.parseInt(st.nextToken());  // 끝월
            endDate[i][1] = Integer.parseInt(st.nextToken());  // 끝일
        }

        int[] monthCal = new int[] {0,
                0, // 1월
                31, // 2월
                59, // 3월
                90,  // 4월
                120,  // 5월
                151,  // 6월
                181,  // 7월
                212,   // 8월
                243,  // 9월
                273,  // 10월
                304,  // 11월
                334 // 12월
                };

        int s = monthCal[3] + 1;  // 3월 1일 시작일
        int e = monthCal[11] + 30;  // 11월 30일 마감일

        int[][] flowerSeasons = new int[N][2];  // flower 의 시작 인덱스, 마감 인덱스

        for (int i = 0; i < N; i++) {
            int startIdx = monthCal[startDate[i][0]] + startDate[i][1];  // 시작 월 + 일
            int endIdx = monthCal[endDate[i][0]] + endDate[i][1];  // 마감 월 + 일
            flowerSeasons[i][0] = startIdx;
            flowerSeasons[i][1] = endIdx;
        }

        int currDate = s;
        int maxEnd = 0;
        int cnt = 0;


        while (currDate <= e) {
            boolean found = false;
            // 현재 currDate 이전에 피고, 가장 멀리가는 꽃 찾기
            for (int i = 0; i < N; i++) {
                if (flowerSeasons[i][0] <= currDate && flowerSeasons[i][1] > maxEnd) {
                    maxEnd = flowerSeasons[i][1];
                    found = true;
                }
            }
            // 만약 해당 꽃을 못찾으면 연결되지 않은 것
            if (!found) {
                cnt = 0;
                break;
            }

            cnt++;
            currDate = maxEnd;
        }

        System.out.println(cnt);
    }
}
