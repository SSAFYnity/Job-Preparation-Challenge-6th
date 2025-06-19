import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stu
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int [] time = new int[n];
		for(int i = 0; i < n; i++) {
			time[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(time); 	 // 도착 시간 정렬
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);	// 내림차순 정렬
		
 		for(int i = 1; i < n; i++) {
 			int dif = time[i] - (time[i-1]+1);		// 현재 도착 시간 - 이전 사람이 나가는 시간
 			if(dif > 0) pq.add(dif);
 		}
 		
 		int total_time = (time[n-1]+1) - time[0];		// 난로가 켜져 있는 시간 초기화(계속 켜져 있는 상태로)
 		
 		for(int i = 0; i < k-1; i++) {
 			if(!pq.isEmpty()) total_time -= pq.poll();	// 대기 시간 큰 순으로 차감하기
 		}
 		
 		// 결과 출력
 		System.out.println(total_time);
	}
}
