import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int D = Integer.parseInt(st.nextToken());	// 오븐깊이
		int N = Integer.parseInt(st.nextToken());	// 피자반죽
		
		int [] oven = new int[D];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < D; i++) {
			oven[i] = Integer.parseInt(st.nextToken());
		}
		
		// 오븐 크기 재설정
		for(int i = 1; i < D; i++) {
			oven[i] = Math.min(oven[i-1], oven[i]);		// 앞에 오븐 통과해야 현재 오븐 통과 가능하니까(정렬을 못하니까)
		}
		
		int curIdx = D;		// 현재 오븐 위치
		
		int result = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			long pizza = Long.parseLong(st.nextToken());	// 피자 지름 입력받기
			
			while(curIdx > 0 && oven[curIdx-1] < pizza) {
				curIdx--;		// 현재 피자의 지름보다 큰 오븐 만날 때까지 구하기
			}
			
			if(curIdx == 0) {				// 더 이상 오븐 사용X
				System.out.println(0);
				return;
			}
			
			curIdx--;	// 그 다음 피자 위해서 현재 위치 한 층 높이기
		}
		
		System.out.println((curIdx+1));
		
	}

}
