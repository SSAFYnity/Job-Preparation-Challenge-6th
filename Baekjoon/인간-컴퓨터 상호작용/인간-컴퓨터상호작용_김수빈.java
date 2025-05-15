import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String S = st.nextToken();
        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());

        int[][] counts = new int[26][S.length() + 1];

        for (int i = 0; i < S.length(); i++) {
            for (int c = 0; c < 26; c++) {
                counts[c][i + 1] = counts[c][i];  // 이전까지 누적 복사
            }
            counts[S.charAt(i) - 'a'][i + 1]++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            char alpha = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append(counts[alpha - 'a'][r + 1] - counts[alpha - 'a'][l]).append('\n');
        }

        System.out.print(sb);


    }
}
