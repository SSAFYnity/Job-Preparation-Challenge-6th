import java.util.*;
import java.io.*;

public class Main {
    static int[] fact = new int[11];

    static int[][][] possibleArr = {
            {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}},
            {{1, 1, 0}, {1, 0, 1}, {0, 1, 1}, {2, 0, 0}, {0, 2, 0}, {0, 0, 2}},
            {{1, 1, 1}, {3, 0, 0}, {0, 3, 0}, {0, 0, 3}},
            {{2, 2, 0}, {0, 2, 2}, {2, 0, 2}, {4, 0, 0}, {0, 4, 0}, {0, 0, 4}},
            {{5, 0, 0}, {0, 5, 0}, {0, 0, 5}},
            {{2, 2, 2}, {3, 3, 0}, {0, 3, 3}, {3, 0, 3}, {6, 0, 0}, {0, 6, 0}, {0, 0, 6}},
            {{7, 0, 0}, {0, 7, 0}, {0, 0, 7}},
            {{4, 4, 0}, {0, 4, 4}, {4, 0, 4}, {8, 0, 0}, {0, 8, 0}, {0, 0, 8}},
            {{3, 3, 3}, {9, 0, 0}, {0, 9, 0}, {0, 0, 9}},
            {{5, 5, 0}, {0, 5, 5}, {5, 0, 5}, {10, 0, 0}, {0, 10, 0}, {0, 0, 10}}};

    static long[][][][] dp = new long[11][101][101][101];  // level, r, g, b
    static boolean[][][][] visited = new boolean[11][101][101][101];
    public static long dfs(int r, int g, int b, int level, int N) {
        if (level == N) {
            return 1L;
        }
        // 방문했을 경우 해당 dp 반환
        if (visited[level][r][g][b]) {
            return dp[level][r][g][b];
        }
        visited[level][r][g][b] = true;

        long total = 0;
        for (int[] curr : possibleArr[level]) {
            int R = r - curr[0];
            int G = g - curr[1];
            int B = b - curr[2];
            if (R >= 0 && G >= 0 && B >= 0) {
                long perms = fact[level + 1] / (1L * fact[curr[0]] * fact[curr[1]] * fact[curr[2]]);
                total += perms * dfs(R, G, B, level + 1, N);
            }
        }
        dp[level][r][g][b] = total;
        return total;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 트리 높이
        int r = Integer.parseInt(st.nextToken());  // red
        int g = Integer.parseInt(st.nextToken());  // green
        int b = Integer.parseInt(st.nextToken());  // blue

        fact[0] = 1;
        for (int i = 1; i <= 10; i++) {
            fact[i] = fact[i - 1] * i;
        }


        System.out.println(dfs(r, g, b, 0, N));




    }
}
