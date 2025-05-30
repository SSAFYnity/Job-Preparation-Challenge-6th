import java.io.*;
import java.util.*;

public class Main {
	static class Point implements Comparable<Point>{
		int u;
		int v;
		int cost;
		
		public Point(int u, int v, int cost) {
			this.u = u;
			this.v = v;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Point p) {
			return this.cost - p.cost;
		}
	}
	
	static int n;
	static int [] parent;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());	// 정점 개수
		
		parent = new int[n+1];
		for(int i = 0; i <= n; i++) parent[i] = i;	// 자기 자신 저장
		
		PriorityQueue<Point> pq = new PriorityQueue<>();
		for(int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = i+1; j <= n; j++) {
				pq.add(new Point(i, j, Integer.parseInt(st.nextToken())));
			}
		}
		
		List<Point> list = new ArrayList<>();
		
		// 크루스칼 알고리즘 이용
		int cnt = 0;
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			
			if(union(p.u, p.v)) {
				cnt++;
				list.add(p);
				if(cnt == n-1) break;
			}
		}
		
		// 원본 인접 리스트
		List<Integer> [] adjList = new ArrayList[n+1];
		for(int i = 0; i <= n; i++) adjList[i] = new ArrayList<>();
		
		for(Point p : list) {
			adjList[p.u].add(p.v);
			adjList[p.v].add(p.u);
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			sb.append(adjList[i].size()).append(" ");
			Collections.sort(adjList[i]);
			for(int num : adjList[i]) sb.append(num+" ");
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	static boolean union(int node1, int node2) {
		int n1 = find(node1);
		int n2 = find(node2);
		
		if(n1 == n2) return false;
		parent[n1] = n2;
		return true;
	}
	
	static int find(int num) {
		if(parent[num] != num) parent[num] = find(parent[num]);
		return parent[num];
	}

}
