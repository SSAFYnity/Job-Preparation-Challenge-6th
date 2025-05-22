import java.io.*;
import java.util.*;

/*
 * 아이디어: 백트래킹..? -> MST
 * 
 * */
public class Main {
	static class Point implements Comparable<Point>{
		int num;
		int cost;
		
		public Point(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Point p) {
			return this.cost - p.cost;	// 비용 기준 내림차순 정렬
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int [] ground = new int[n+1];		// 1번~n번까지 논
		
		List<List<Point>> graph = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 1; i <= n; i++) {
			int cost = Integer.parseInt(br.readLine());	
			graph.get(0).add(new Point(i, cost));	// 우물의 정점0과 초기 논을 각각 연결하기
			graph.get(i).add(new Point(0, cost));
		}

		for(int i = 1; i <= n; i++) {	// 각 논별로 연결하기
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				int cost = Integer.parseInt(st.nextToken());
				if(i != j) {	// 자기 자신 제X외
					graph.get(i).add(new Point(j, cost));				
				}
			}
		}
		
		//Prim 알고리즘
		boolean [] visited = new boolean[n+1];	// 각 논별 방문 확인 배열
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(0, 0));	// 우물 정점에서 시작하기
		
		int minCost = 0;	// 최솟값
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			
			if(visited[p.num]) continue;	// 이미 방문 완료
			
			visited[p.num] = true;
			
			minCost += p.cost;
			
			for(Point nextP : graph.get(p.num)) {
				if(!visited[nextP.num]) pq.add(nextP);
			}
		}
		
		System.out.println(minCost);
	}

}
