import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            double x = Double.parseDouble(br.readLine());
            bw.write(solve(x));
            bw.newLine();
        }

        bw.flush();
    }

    static String solve(double x) {
        double left = 0.0;
        double right = (x < 1.0) ? 1.0 : x;

        while (right - left > 1e-11) {
            double mid = (left + right) / 2.0;
            double midCubed = mid * mid * mid;

            if (midCubed > x) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return String.format("%.10f", left);
    }
}
