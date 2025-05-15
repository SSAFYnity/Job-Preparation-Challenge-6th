import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer> primeNum;
    private static int[] searchGoldenBach(int number) {
        int[] result = new int[2];
        for (int i = 0; i < primeNum.size(); i++) {
            int a = primeNum.get(i);
            int b = number - a;
            if (a > b) {
                break;
            }
            if (primeNum.contains(b)) {
                result[0] = a;
                result[1] = b;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());  // 테스트 케이스
        primeNum = new ArrayList<>();  // 10000까지 소수 모음
        for (int i = 2; i < 10000; i++) {
            boolean flag = true;
            for (int j = (int) Math.sqrt(i); j >= 2; j--) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                primeNum.add(i);
            }
        }
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());  // 확인해야 할 짝수
            int[] goldenBach = searchGoldenBach(number);
            System.out.println(goldenBach[0] + " " + goldenBach[1]);
        }
    }
}
