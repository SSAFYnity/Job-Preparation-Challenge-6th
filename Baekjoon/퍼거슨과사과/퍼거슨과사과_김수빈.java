import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());  // 빨간 사과
        int G = Integer.parseInt(st.nextToken());  // 초록 사과

        int minApple = Math.min(R, G);

        for (int i = 1; i <= minApple; i++) {
            if (R % i == 0 && G % i == 0) {
                System.out.println(i + " " + R / i + " " + G / i);
            }
        }
    }
}
