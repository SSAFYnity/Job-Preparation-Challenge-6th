import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());  // 팀의 수 N
            int A = Integer.parseInt(st.nextToken());  // 풍선 수 A
            int B = Integer.parseInt(st.nextToken());  // 풍선 수 B

            if (N == 0 && A == 0 && B == 0) {
                break;
            }

            int[][] teams = new int[N][3];  // 팀
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                teams[i][0] = Integer.parseInt(st.nextToken());  // 풍선 수
                teams[i][1] = Integer.parseInt(st.nextToken());  // A 거리
                teams[i][2] = Integer.parseInt(st.nextToken());  // B 거리
            }

            Arrays.sort(teams, (a, b) ->
                Integer.compare(Math.abs(b[1] - b[2]), Math.abs(a[1] - a[2]))
            );

            int dist = 0;

            for (int[] team : teams) {
                int k = team[0], da = team[1], db = team[2];

                if (da < db) {
                    int fromA = Math.min(k, A);
                    dist += fromA * da;
                    A -= fromA;
                    k -= fromA;

                    dist += k * db;
                    B -= k;
                } else {
                    int fromB = Math.min(k, B);
                    dist += fromB * db;
                    B -= fromB;
                    k -= fromB;

                    dist += k * da;
                    A -= k;
                }
            }

            System.out.println(dist);

        }

    }
}
