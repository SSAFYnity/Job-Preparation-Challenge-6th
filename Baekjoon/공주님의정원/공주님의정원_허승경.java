import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int [][] arr = new int[n][4];
		// 0. 입력받기
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startMonth = Integer.parseInt(st.nextToken());
			int startDay = Integer.parseInt(st.nextToken());
			int endMonth = Integer.parseInt(st.nextToken());
			int endDay = Integer.parseInt(st.nextToken());
			
			// ->3자리로 바꾸기
			arr[i][0] = startMonth*100+startDay;	// 시작 날짜
			arr[i][1] = endMonth*100+endDay;		// 끝나는 날짜
		}
		
		// 1. 정렬
		Arrays.sort(arr, (a, b) -> {
			if(a[0] == b[0]) return a[1] - b[1];		// 시작 날 오름차순, 끝나는 날 내림차순
			return a[0] - b[0];
		});
		
		// 2. 구현
		int targetDay = 301;	// 꽃은 3월 1일부터 펴있어야함
		int idx = 0;
		int maxDay = 0;
		int cnt = 0;
		
		while(targetDay < 1201) {
			boolean flag = false;
			
			while(idx < n && arr[idx][0] <= targetDay) {
				if(arr[idx][1] > maxDay) {		// targetDay 이전에 피기 시작하는 꽃 중, 가장 늦게까지 피는 꽃 선택
					maxDay = arr[idx][1];		// 갱신
					flag = true;
				}
				idx++;
			}
			
			if(!flag) {
				cnt = 0;
				break;
			}
			
			targetDay = maxDay;				// 현재, 가장 마지막까지 꽃이 피는 날짜로 갱신
			cnt++;
		}
		
		if(cnt == 0) System.out.println(0);
		else System.out.println(cnt);
	}

}
