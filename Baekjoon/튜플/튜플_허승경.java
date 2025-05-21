import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        String tmp = s.substring(2, s.length()-2);
        
        String [] arr = tmp.split("\\},\\{");
        Arrays.sort(arr, (a, b) -> a.length() - b.length());
        List<Integer> list = new ArrayList<>();
        
        for(String ar : arr){
            String [] str = ar.split(",");
            for(String st : str){
                int num = Integer.parseInt(st);
                if(!list.contains(num)) list.add(num);
            }
            
        }
        
        int [] answer = new int[list.size()];
        int cnt = 0;
        
        for(int num : list){
            answer[cnt++] = num;
        }
        
        return answer;
    }
}