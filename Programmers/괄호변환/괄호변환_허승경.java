import java.util.*;

class Solution {
    public String solution(String p) {
        if(p.length() == 0) return p;   // 빈 문자열 반환
        
        int idx = splitString(p);
        String u = p.substring(0, idx + 1);     // 균형잡힌 괄호 문자열
        String v = p.substring(idx + 1);
        
        if(checkString(u)){     // 올바른 괄호 문자열 판단
            return u+solution(v);
        }else{
            StringBuilder sb = new StringBuilder();
            
            sb.append("(");
            sb.append(solution(v));
            sb.append(")");
            
            for (int i = 1; i < u.length() - 1; i++) {
                char c = u.charAt(i);
                if (c == '(') {
                    sb.append(')');
                } else {
                    sb.append('(');
                }
            }
            return sb.toString();
        }

    }
    
    boolean checkString(String str){
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                stack.push('(');
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                }else return false;
            }
        }
        
        if(stack.isEmpty()) return true;
        else return false;
    }
    
    int splitString(String str){
        int open = 0;
        int close = 0;
        
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                open++;
            }else{
                close++;
            }
            
            if(open == close) return i; // 균형잡힌 괄호 문자열 최소 길이
        }
        
        return str.length();
    }
}