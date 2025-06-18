import java.util.*;

class Solution {
    static int maxDiff = 0;
    static int[] bestShot = new int[] {-1};

    private static void backtracking(int score, int apeachScore, int idx, int n, int[] info, int[] currShot) {
        // 화살을 다 썼거나 혹은 마지막 인덱스인 경우
        if (idx >= 11 || n == 0) {
            // 어피치보다 점수가 큰 경우만 이김
            if (score > apeachScore) {
                currShot[10] = n;
                if (maxDiff < score - apeachScore) {  // 최고 차이일 경우
                    maxDiff = score - apeachScore;
                    bestShot = Arrays.copyOf(currShot, 11);
                } else if (maxDiff == score - apeachScore) {  // 기존 최고 차이가 같다면
                    for (int i = 10; i >= 0; i--) {
                        // 더 낮은 값의 점수가 많은 경우를 택함
                        if (currShot[i] > bestShot[i]) {
                            bestShot = Arrays.copyOf(currShot, 11);
                            break;
                        } else if (currShot[i] < bestShot[i]) {
                            break;
                        }
                    }
                }
            }
            return;
        }

        // 남은 화살이 어피치가 해당 점수에 쏜 것보다 많은 경우
        if (n > info[idx]) {
            // 어피치보다 많이 쏘거나
            int shotNum = info[idx] + 1;
            currShot[idx] = shotNum;
            int k = 10 - idx;
            // 해당 점수에 어피치가 쏘지 않았다면 어피치 점수는 그대로
            if (info[idx] == 0) {
                backtracking(score + k, apeachScore, idx + 1, n - shotNum, info, currShot);
            } else {
                backtracking(score + k, apeachScore - k, idx + 1, n - shotNum, info, currShot);
            }
        }
        // 아예 안쏘거나
        currShot[idx] = 0;
        backtracking(score, apeachScore, idx + 1, n, info, currShot);
    }
    public static int[] solution(int n, int[] info) {
        int apeachScore = 0;
        for (int i = 0; i <= 10; i++) {
            if (info[i] > 0) {
                apeachScore += (10 - i);
            }
        }
        int[] currShot = new int[11];
        backtracking(0, apeachScore, 0, n, info, currShot);
        return bestShot;
    }
}
