import java.util.*;
import java.io.*;

public class Main {
    static int[][] sudoku;
    static List<int[]> blanks;
    public static void main(String[] args) throws IOException {
        blanks = new ArrayList<>();
        // 스도쿠 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sudoku = new int[9][9];
        int cnt = 0;
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = line.charAt(j) - '0';
                // 빈칸 위치 저장
                if (sudoku[i][j] == 0) {
                    blanks.add(new int[]{i, j});
                }
            }
        }

        dfs(0);

    }
    private static boolean dfs(int index) {
        if (index == blanks.size()) {
            // 다 채웠으면 결과 출력
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(sudoku[i][j]);
                }
                System.out.println();
            }
            return true;
        }

        int[] pos = blanks.get(index);
        int r = pos[0], c = pos[1];

        for (int num = 1; num <= 9; num++) {
            if (isValid(r, c, num)) {
                sudoku[r][c] = num;
                if (dfs(index + 1)) return true;
                sudoku[r][c] = 0;
            }
        }
        return false;
    }

    private static boolean isValid(int r, int c, int num) {
        // row, col 검사
        for (int k = 0; k < 9; k++) {
            if (sudoku[r][k] == num || sudoku[k][c] == num) {
                return false;
            }
        }
        // 미니 사각형 검사
        int miniStartR = (r / 3) * 3;
        int miniStartC = (c / 3) * 3;
        for (int i = miniStartR; i < miniStartR + 3; i++) {
            for (int j = miniStartC; j < miniStartC + 3; j++) {
                if (sudoku[i][j] == num) {
                    return false;
                }
            }
        }
        return true;

    }
}
