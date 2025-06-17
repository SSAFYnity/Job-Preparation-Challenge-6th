import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());  // 오븐 깊이
        int N = Integer.parseInt(st.nextToken());  // 반죽 개수

        int[] oven = new int[D];  // 오븐 깊이마다 지름
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < D; i++) {
            oven[i] = Integer.parseInt(st.nextToken());
        }
        int[] dough = new int[N];  // 반죽 지름
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dough[i] = Integer.parseInt(st.nextToken());
        }

        // 오븐의 지름이 점점 작아지는 전처리
        for (int i = 1; i < D; i ++) {
            oven[i] = Math.min(oven[i], oven[i - 1]);
        }

        // 오븐 가장 깊은 위치부터 탐색
        int pos = D;
        for (int i = 0; i < N; i++) {
            int d = dough[i];
            // 오븐 위에서부터 아래로 내려오며 맞는 위치 찾기
            while (pos > 0 && oven[pos - 1] < d) {
                pos-- ;
            }
            if (pos == 0) {
                System.out.println(0);
                return;
            }
            pos--;  // 도우 하나 넣음
        }
        System.out.println(pos + 1);
    }
}
