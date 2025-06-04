import java.io.*;
import java.util.*;

/*
 * 아이디어: dp
 * 주의 : 같은 색이라도 순서가 달라지면 다른걸로
 * 1. k레벨 구성 방법
 * (1) 한가지 색으로 꾸미기
 * (2) 두 가지 색으로 꾸미기 -> k단이 2의 배수여야 함.
 * (3) 세 가지 색으로 꾸미기 -> k단이 3의 배수여야 함.
 * */

public class Main {
	static long [][][][] dp;
	static long [] factorial;
	static long [][] combination;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());	// 트리의 크기
		int red = Integer.parseInt(st.nextToken());		// 빨간색 개수
		int green = Integer.parseInt(st.nextToken());	// 초록색 개수
		int blue = Integer.parseInt(st.nextToken());	// 파란색 개수
		
		dp = new long[n+1][red+1][green+1][blue+1];	// 경우의 수
		factorial = new long[n+1];
		combination = new long[n+1][n+1];
		
		System.out.println(dfs(n, red, green, blue));
		
	}
	
	static long dfs(int n, int red, int green, int blue) {
		if( red < 0 || green < 0 || blue < 0) return 0;	// 진행 No
		
		if (n <= 0) return 1;
		
		if(dp[n][red][green][blue] != 0) return dp[n][red][green][blue];
		
		// 1가지 색상 이용
		dp[n][red][green][blue] += dfs(n-1, red-n, green, blue);
		dp[n][red][green][blue] += dfs(n-1, red, green-n, blue);
		dp[n][red][green][blue] += dfs(n-1, red, green, blue-n);
		
		// 2가지 색상 이용 -> n이 2의 배수일 때만
		if(n%2 == 0) {
			int cnt = n/2;	// 각 색상 당, 반절씩 이용
			dp[n][red][green][blue] += dfs(n-1, red-cnt, green-cnt, blue) * comb(n, cnt);
			dp[n][red][green][blue] += dfs(n-1, red-cnt, green, blue-cnt) * comb(n, cnt);
			dp[n][red][green][blue] += dfs(n-1, red, green-cnt, blue-cnt) * comb(n, cnt);
		}
		
		// 3가지 색상 이용 -> n이 3의 배수일 때만
		if(n%3 == 0) {
			int cnt = n/3; 	// 각 색상 당, 1/3 씩 이용
			// 처음 cnt, 그 다음 cnt, 나머지 cnt는 자동으로 1
			dp[n][red][green][blue] += dfs(n-1, red-cnt, green-cnt, blue-cnt) * 
					comb(n, cnt) * comb(n-cnt, cnt) * 1;
		}
		
		return dp[n][red][green][blue];
	}

	static long comb(int n, int r) {
		if(combination[n][r] != 0) return combination[n][r];
		
		combination[n][r] = facto(n) / (facto(r)*facto(n-r));
		return combination[n][r];
	}
	
	static long facto(int n) {
		if(n == 0 || n == 1) return 1;
		
		if(factorial[n] != 0) return factorial[n];
		
		return n*facto(n-1);
	}

}
