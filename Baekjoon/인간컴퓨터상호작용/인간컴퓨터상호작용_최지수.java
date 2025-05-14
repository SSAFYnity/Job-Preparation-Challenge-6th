import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();

        int T = Integer.parseInt(br.readLine());

        int[][] arr = new int[26][s.length()];
        arr[s.charAt(0)-'a'][0] = 1;
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j < s.length(); j++) {
                arr[i][j] = arr[i][j-1];
                if (((char) ('a' + i)) == s.charAt(j)) arr[i][j]++;
            }
        }

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            int sta = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (sta == 0) sb.append(arr[a-'a'][end]).append("\n");
            else sb.append(arr[a-'a'][end] - arr[a-'a'][sta-1]).append("\n");
        }

        System.out.println(sb.toString());
    }
}

