import java.util.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    // 올바른 괄호인지 확인
    private static boolean rightBrace(String braces) {
        Stack<Character> open = new Stack<>();
        for (int i = 0; i < braces.length(); i++) {
            char b = braces.charAt(i);
            if (b == '(') {
                open.push(b);
            } else if (b == ')') {
                if (open.isEmpty()) {
                    return false;
                } else {
                    open.pop();
                }
            }
        }
        return true;
    }

    // u랑 v를 분리하기
    private static String[] splitBrace(String braces) {
        if (braces.equals("")) {
            return new String[] {"", ""};
        }
        int openBrace = 0;
        int closeBrace = 0;
        int idx = 0;
        do {
            char b = braces.charAt(idx);
            if (b == '(') {
                openBrace++;
            } else if (b == ')') {
                closeBrace++;
            }
            idx++;

        } while (openBrace != closeBrace);

        String u = braces.substring(0, idx);
        String v = "";
        if (idx < braces.length()) {
            v = braces.substring(idx);
        }

        String[] newBrace = new String[] {u, v};
        return newBrace;
    }

    // 괄호 변환
    private static void transBrace(String p) {
        String[] braces = splitBrace(p);
        String u = braces[0];
        String v = braces[1];
        if (u.equals("")) {
            return;
        }

        if (rightBrace(u)) {  // 올바른 괄호 문자열이라면
            // 올바른 문자열이라면 sb에 넣고
            for (int j = 0; j < u.length(); j++) {
                sb.append(u.charAt(j));
            }
            // v에 대해 다시 재귀 과정 실행
            transBrace(v);
        } else {  // 올바른 괄호 문자열이 아니라면
            sb.append("(");
            transBrace(v);
            sb.append(")");
            u = u.substring(1, u.length() - 1);
            for (int j = 0; j < u.length(); j++) {
                char b = u.charAt(j);
                if (b == '(') {
                    sb.append(')');
                } else {
                    sb.append('(');
                }
            }


        }
    }

    public String solution(String p) {
        // 이미 올바른 괄호일 경우 바로 리턴
        if (rightBrace(p)) {
            return p;
        }

        transBrace(p);



        String answer = sb.toString();
        return answer;
    }
}
