import java.util.*;
import java.io.*;

public class Main {

    static int n, m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        boolean[] sosu = new boolean[10000];
        Arrays.fill(sosu, true);
        sosu[0] = sosu[1] = false;

        for (int i = 2; i < 100+1; i++) {
            if (!sosu[i]) continue;
            for (int j = i*i; j < 10000; j+=i) {
                sosu[j] = false;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 4) {sb.append(2+" "+2+"\n"); continue;}
            int start = num / 2 - ((num/2)%2==0? 1: 0);
            for (int j = start; j >= 3; j-=2) {
                if (sosu[j] && sosu[num-j]) {sb.append(j+" " +(num-j)+"\n"); break;}
            }
        }

        System.out.println(sb.toString());
    }
}

