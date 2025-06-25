import java.util.*;

class Solution {
    public class Point{
        int idx;
        int x;
        int y;
        Point left;
        Point right;
        
        public Point(int idx, int x, int y){
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
    }
    
    int curIdx;         // 순회 시, 인덱스
    int [][] answer;
    
    public int[][] solution(int[][] nodeinfo) {
        // 정답 배열 초기화
        answer = new int[2][nodeinfo.length];
        
        // 입력 값 정리하기
        List<Point> points = new ArrayList<>();
        for(int i = 0; i < nodeinfo.length; i++){
            points.add(new Point(i+1, nodeinfo[i][0], nodeinfo[i][1])); // index 0부터니까
        }
        
        // y 기준 내림차순, x 기준 오름차순 정렬
        
        points.sort((a,b) -> {
           if(a.y == b.y) return a.x-b.x;
            return b.y-a.y;
        });
        
        // 트리 구성하기
        Point root = points.get(0); // 첫번째 원소가 루트 노드
        for(int i = 1; i < nodeinfo.length; i++){
            insert(root, points.get(i));    // root 노드 기준으로 현재 노드 삽입하기
        }
        
        // 전위 순회
        curIdx = 0;
        preOrder(root);
        
        // 후위 순회
        curIdx = 0;
        postOrder(root);
        
        return answer;
    }
    
    void insert(Point parent, Point child){
        if(child.x < parent.x){               // 부모노드 x값보다 작음 -> 왼쪽
            if(parent.left == null) parent.left = child;
            else insert(parent.left, child);
        }else{                              // 부모 노드 x값보다 크거나 같음 -> 오른쪽
            if(parent.right == null) parent.right = child;
            else insert(parent.right, child);
        }
    }
    
    void preOrder(Point point){
        if(point != null){
            answer[0][curIdx++] = point.idx;
            preOrder(point.left);
            preOrder(point.right);
        }
    }
  
    void postOrder(Point point){
        if(point != null){
            postOrder(point.left);
            postOrder(point.right);
            answer[1][curIdx++] = point.idx;
        }
    }
}