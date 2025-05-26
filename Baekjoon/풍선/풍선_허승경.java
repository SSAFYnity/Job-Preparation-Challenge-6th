import java.io.*;
import java.util.*;

/*
 * 생각나는 아이디어: PQ, 이분탐색, 백트래킹, 그리디, 정렬
 * 
 * */
public class Main {

	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());	// 팀의 수
		int aCount = Integer.parseInt(st.nextToken());	// A풍선 재고
		int bCount = Integer.parseInt(st.nextToken());	// B풍선 재고
		
		int [][] info = new int[n][3];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				info[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.readLine();	// 마지막 줄 처리(0, 0, 0)
		
		// 정렬 -> 기준: 두 거리의 차가 큰 것으로 정렬하기
		Arrays.sort(info, (a, b) -> {
		    int diff = Math.abs(b[1] - b[2]) - Math.abs(a[1] - a[2]);
		    if (diff != 0) return diff;

		    // 동일한 경우 -> 풍선 재고가 많은 가게 먼저
		    return b[0] - a[0];
		});
		
		int answer = 0;
		for(int i = 0; i < n; i++) {
			int curAcount = 0;	// 현재 팀에서 사용하는 a풍선 수
			int curBcount = 0; 	// 현재 팀에서 사용하는 b풍선 수
			
			if(info[i][1] < info[i][2]) {		// a가 더 가까움
				curAcount = Math.min(aCount, info[i][0]);
				curBcount = info[i][0] - curAcount;
			}else if(info[i][1] > info[i][2]) {	// b가 더 가까움
				curBcount = Math.min(bCount, info[i][0]);
				curAcount = info[i][0] - curBcount;
			}else {	// 둘 다 동일한 거리 -> 재고가 많은 걸로 선택
				if(aCount >= bCount) {
					curAcount = Math.min(aCount, info[i][0]);
					curBcount = info[i][0] - curAcount;
				}else {
					curBcount = Math.min(bCount, info[i][0]);
					curAcount = info[i][0] - curBcount;
				}
			}
			
			// 계산
			answer += info[i][1]*curAcount + info[i][2]*curBcount;
			aCount -= curAcount;
			bCount -= curBcount;

		}
		
		System.out.println(answer);
	}

}
