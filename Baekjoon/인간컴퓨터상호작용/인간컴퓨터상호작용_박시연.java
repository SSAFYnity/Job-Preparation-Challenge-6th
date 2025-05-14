import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int q = Integer.parseInt(br.readLine());

        int len = S.length();
        // 알파벳 26개 각각에 대해 누적합 배열
        int[][] prefix = new int[26][len + 1];

        for (int i = 0; i < len; i++) {
            int c = S.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                prefix[j][i + 1] = prefix[j][i] + (j == c ? 1 : 0);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char alpha = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int idx = alpha - 'a';
            int count = prefix[idx][r + 1] - prefix[idx][l];
            sb.append(count).append('\n');
        }

        System.out.print(sb);
    }
}
