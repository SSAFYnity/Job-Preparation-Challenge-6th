import java.util.*;
import java.io.*;

public class Main {
    static boolean found;
    static int all;
    static StringBuilder answer = new StringBuilder();
    static int[][] sudoku = new int[9][9];
    static int[] squ = new int[9], ver = new int[9], hor = new int[9];

    static boolean isSet(int bit, int idx) {return (bit & (1 << idx)) != 0;}
    static int use(int bit, int idx) {return bit | (1 << idx);}
    static int clear(int bit, int idx) {return bit & ~(1 << idx);}

    static void fix(int y, int x, int i) {
        squ[squWV(y,x)] = use(squ[squWV(y,x)], i);
        hor[y] = use(hor[y], i);
        ver[x] = use(ver[x], i);
    }

    static void unfix(int y, int x, int i) {
        squ[squWV(y,x)] = clear(squ[squWV(y,x)], i);
        hor[y] = clear(hor[y], i);
        ver[x] = clear(ver[x], i);
    }

    static int squWV(int y, int x) {
        return y / 3 * 3 + x / 3;
    }

    static void back(int wv) {
        if (found) return;
        if (wv >= 81) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    answer.append(sudoku[i][j]);
                }
                answer.append("\n");
            }
            found = true;
            return;
        }

        int y = wv / 9;
        int x = wv % 9;
        if (sudoku[y][x] != 0) {
            back(wv+1);
            return;
        }

        int bit = squ[squWV(y,x)] | hor[y] | ver[x];
        if (bit == all) return;

        for (int i = 1; i <= 9; i++) {
            if (!isSet(bit, i)) {
                fix(y,x,i);
                sudoku[y][x] = i;
                back(wv+1);
                sudoku[y][x] = 0;
                unfix(y,x,i);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = str.charAt(j) - '0';
                if (sudoku[i][j] == 0) continue;
                squ[squWV(i,j)] = use(squ[squWV(i,j)], sudoku[i][j]);
                hor[i] = use(hor[i], sudoku[i][j]);
                ver[j] = use(ver[j], sudoku[i][j]);
            }
        }

        for (int i = 1; i <= 9; i++) { all = use(all, i); }

        back(0);

        System.out.println(answer.toString());
    }
}

