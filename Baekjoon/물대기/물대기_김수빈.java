import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] link = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            int c = Integer.parseInt(br.readLine());
            // 우물 비용
            link[i][0] = c;
            link[0][i] = c;
        }
        for (int i = 1; i <= N; i++) {
            // 연결 비용
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                link[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] water = new boolean[N + 1];
        water[0] = true;
        int next = 0;
        int cost = 0;
        int cnt = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        while (cnt < N) {
            // 현재 정점에서 간선이 작은걸 큐에 넣기
            for (int i = 0; i <= N; i++) {
                pq.add(new int[] {i, link[next][i]});
            }
            while (true) {
                int[] land = pq.poll();
                // 만약 해당 땅이 이미 water가 나왔다면 패스
                if (water[land[0]]) {
                    continue;
                }
                cost += land[1];
                next = land[0];
                water[land[0]] = true;
                cnt++;
                break;
            }
        }

        System.out.println(cost);


    }
}
